package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.ProductoTO;
import com.uce.edu.demo.repository.modelo.ReporteTO;


public interface IVentaService {

public BigDecimal realizarVenta(String numeroVenta, String cedula, List<ProductoTO> producto);
	
	public List<ReporteTO> reporte(LocalDateTime fechaVenta,String categoria,Integer cantidad);
	
	
	
}
