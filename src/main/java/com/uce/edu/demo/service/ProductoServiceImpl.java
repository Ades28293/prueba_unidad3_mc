package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoStockTO;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		try {
			Producto busquedaProducto = this.iProductoRepository.buscarCodigoBarras(producto.getCodigoBarras());

			busquedaProducto.setStock(busquedaProducto.getStock() + producto.getStock());
			this.iProductoRepository.actualizar(busquedaProducto);

		} catch (Exception e) {
			this.iProductoRepository.insertar(producto);

		}
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(producto);
	}

	@Override
	public Producto buscarCodigoBarras(String codigo) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarCodigoBarras(codigo);
	}

	@Override
	public ProductoStockTO buscarStock(String codigo) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarStock(codigo);
	}

}
