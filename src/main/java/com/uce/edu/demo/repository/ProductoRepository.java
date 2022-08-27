package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoStockTO;

@Repository
@Transactional
public class ProductoRepository implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarCodigoBarras(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras=:codigo ", Producto.class);
		myQuery.setParameter("codigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public ProductoStockTO buscarStock(String codigo) {
		// TODO Auto-generated method stub
	
		Query myQuery = this.entityManager.createNativeQuery(
				"SELECT prod_codigoBarras,prod_categoria,prod_nombre,prod_stock FROM producto WHERE prod_codigoBarras=:codigo",
				ProductoStockTO.class);

		myQuery.setParameter("codigo", codigo);

		return (ProductoStockTO) myQuery.getSingleResult();

	}

}
