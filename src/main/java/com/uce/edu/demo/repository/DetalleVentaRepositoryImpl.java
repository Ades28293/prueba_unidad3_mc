package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.DetalleVenta;



@Repository
@Transactional
public class DetalleVentaRepositoryImpl implements IDetalleVentaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleVenta);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<DetalleVenta> reporte(LocalDateTime fechaVenta) {
		// TODO Auto-generated method stub
		TypedQuery<DetalleVenta> query = this.entityManager.createQuery(
				"SELECT d FROM DetalleVenta d,Venta v WHERE d.venta=v AND v.fecha>=: datoFecha",DetalleVenta.class );
		query.setParameter("datoFecha", fechaVenta);
		
	
		 List<DetalleVenta> m=query.getResultList();
		for (DetalleVenta detalleVenta : m) {
			detalleVenta.getProducto().getId();
		}
		return m;
		
	}
	

}
