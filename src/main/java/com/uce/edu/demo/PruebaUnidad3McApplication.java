package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoStockTO;
import com.uce.edu.demo.repository.modelo.ProductoTO;
import com.uce.edu.demo.repository.modelo.ReporteTO;
import com.uce.edu.demo.service.IProductoService;
import com.uce.edu.demo.service.IVentaService;

@SpringBootApplication
public class PruebaUnidad3McApplication implements CommandLineRunner{
	private static final Logger LOGGER = Logger.getLogger(PruebaUnidad3McApplication.class);

	@Autowired
	private IProductoService iProductoService;
	
	@Autowired IVentaService iVentaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad3McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Producto prod=new Producto();
		prod.setCategoria("Dulce");
		prod.setCodigoBarras("aasd654");
		prod.setNombre("Amor");
		prod.setPrecio(new BigDecimal(2.50));
		prod.setStock(30);
		
		Producto prod2=new Producto();
		prod2.setCategoria("vegetales");
		prod2.setCodigoBarras("veg125");
		prod2.setNombre("Culantro");
		prod2.setPrecio(new BigDecimal(1.50));
		prod2.setStock(25);
		
		this.iProductoService.insertar(prod);
		this.iProductoService.insertar(prod2);
		
		ProductoTO productoTO=new ProductoTO();
		productoTO.setCodigoBarras("veg125");
		productoTO.setCantidad(2);;
		
		List<ProductoTO> carrito=new ArrayList<ProductoTO>();
		carrito.add(productoTO);
		
		this.iVentaService.realizarVenta("01","1720757101", carrito);
		
		//Funcionalidad c
		Producto pr=this.iProductoService.buscarCodigoBarras("aasd654");
		LOGGER.info("Buscar Codigo Barras: "+pr);
		
	/*	ProductoStockTO p2=this.iProductoService.buscarStock("veg125");
		LOGGER.info("Buscar Stock:"+p2);
		*/
		//Funcionalidadd d
		List<ReporteTO> report=this.iVentaService.reporte(LocalDateTime.of(2022, 8,26 , 0, 0), "vegetales", 2);
		report.forEach(e -> LOGGER.info("Reporte: "+e));
		
	}

}
