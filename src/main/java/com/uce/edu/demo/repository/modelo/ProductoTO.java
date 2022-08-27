package com.uce.edu.demo.repository.modelo;

public class ProductoTO {

	private String codigoBarras;
	private Integer cantidad;
	
	//Constructor por Defecto
	public ProductoTO() {

	}

	public ProductoTO(String codigoBarras, Integer cantidad) {
		super();
		this.codigoBarras = codigoBarras;
		this.cantidad = cantidad;
	}
	
	//Set y Get

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ProductoTO [codigoBarras=" + codigoBarras + ", cantidad=" + cantidad + "]";
	}
	
	

	
}
