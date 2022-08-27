package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoStockTO;

public interface IProductoService {
	
	public void insertar(Producto producto);
	
	public void actualizar(Producto producto);
	
	public Producto buscarCodigoBarras(String codigo);
	
	public ProductoStockTO buscarStock(String codigo);

}
