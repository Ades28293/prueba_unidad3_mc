package com.uce.edu.demo.repository.modelo;

public class ProductoStockTO {

	private String codigoBarras;
	private String categoria;
	private String nombre;
	private Integer stock;
	
	//Constructor por Defecto
	public ProductoStockTO() {

	}

	public ProductoStockTO(String codigoBarras, String categoria, String nombre, Integer stock) {
		super();
		this.codigoBarras = codigoBarras;
		this.categoria = categoria;
		this.nombre = nombre;
		this.stock = stock;
	}
	
	//Set y Get

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ProductoStockTO [codigoBarras=" + codigoBarras + ", categoria=" + categoria + ", nombre=" + nombre
				+ ", stock=" + stock + "]";
	}
	
	
	

	
}
