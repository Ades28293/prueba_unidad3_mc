package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

public class ReporteTO {

	private String codigoBarras;
	private String categoria;
	private Integer cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal subtotal;
	
	//Contructor por Defecto
	public ReporteTO() {

	}

	public ReporteTO(String codigoBarras, String categoria, Integer cantidad, BigDecimal precioUnitario,
			BigDecimal subtotal) {
		super();
		this.codigoBarras = codigoBarras;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "ReporteTO [codigoBarras=" + codigoBarras + ", categoria=" + categoria + ", cantidad=" + cantidad
				+ ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + "]";
	}
	
	

}
