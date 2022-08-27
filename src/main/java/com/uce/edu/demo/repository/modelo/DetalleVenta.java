package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "detalle")
public class DetalleVenta {

	@Id
	@Column(name = "debe_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "debe_id_seq") 
	@SequenceGenerator(name = "debe_id_seq", sequenceName = "debe_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "debe_cantidad")
	private Integer cantidad;
	
	@Column(name = "debe_precio_unitario")
	private BigDecimal precioUnitario;
	
	@Column(name = "debe_subtotal")
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name="debe_fact_id")
	private Venta venta;

	
	@ManyToOne
	@JoinColumn(name="debe_prod_id")
	private Producto producto;
	
	//Set y Get 


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Venta getVenta() {
		return venta;
	}


	public void setVenta(Venta venta) {
		this.venta = venta;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	
	
	

	
}
