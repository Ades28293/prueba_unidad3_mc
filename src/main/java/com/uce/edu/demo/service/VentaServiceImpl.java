package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleVentaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.IVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoTO;
import com.uce.edu.demo.repository.modelo.ReporteTO;
import com.uce.edu.demo.repository.modelo.Venta;
import com.uce.edu.demo.service.functional.IFuntion;

@Service
public class VentaServiceImpl implements IVentaService{
	
	@Autowired 
	private IVentaRepository iVentaRepository;
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Autowired
	private IDetalleVentaRepository detalleVentaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public BigDecimal realizarVenta(String numeroVenta, String cedula, List<ProductoTO> producto) {
		// TODO Auto-generated method stub
		List<DetalleVenta> detalles =new ArrayList<>();
		BigDecimal totalPagarVenta= new BigDecimal(0);
		
		Venta vent=new Venta();
		vent.setCedulaCliente(cedula);
		vent.setFecha(LocalDateTime.now());
		vent.setNumero(numeroVenta);
		
		for(ProductoTO codigoProd : producto) {
			
			DetalleVenta debe=new DetalleVenta();
			debe.setCantidad(codigoProd.getCantidad());
			debe.setVenta(vent);
			
			Producto produc=this.iProductoRepository.buscarCodigoBarras(codigoProd.getCodigoBarras());
			if(produc.getStock()>=debe.getCantidad()) {
				debe.setProducto(produc);
				debe.setPrecioUnitario(produc.getPrecio());
				debe.setSubtotal(produc.getPrecio().multiply(new BigDecimal(debe.getCantidad())));
				totalPagarVenta = totalPagarVenta.add(debe.getSubtotal());
				produc.setStock(produc.getStock() - debe.getCantidad());
				
				this.iProductoRepository.actualizar(produc);
				detalles.add(debe);
			}else {
				throw new RuntimeException();
			}
			
		}
		
		vent.setDetalles(detalles);
		vent.setTotalVenta(totalPagarVenta);
		this.iVentaRepository.insertar(vent);
		
		
	return totalPagarVenta;
	}

	@Override
	public List<ReporteTO> reporte(LocalDateTime fechaVenta, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		
		List<DetalleVenta> detalles =this.detalleVentaRepository.reporte(fechaVenta);
		
		IFuntion<ReporteTO, ReporteTO> filtro=r ->{
			if (r.getCategoria().equals(categoria)) {
				if (r.getCantidad() >= cantidad) {
					return r;
				}
			}
			return null;
		};
		
		List<ReporteTO> reportesList =new ArrayList<>();
		
		for(DetalleVenta detalleVenta : detalles) {
			ReporteTO reporteTO=new ReporteTO();
			reporteTO.setCantidad(detalleVenta.getCantidad());
			reporteTO.setPrecioUnitario(detalleVenta.getPrecioUnitario());
			reporteTO.setSubtotal(detalleVenta.getSubtotal());
			reporteTO.setCategoria(detalleVenta.getProducto().getCategoria());
			reporteTO.setCodigoBarras(detalleVenta.getProducto().getCodigoBarras());
			
			ReporteTO re= filtro.apply(reporteTO);
			if(re!=null) {
				reportesList.add(re);
			}
			
		}
		
		
		return reportesList;
	}
	
	

}
