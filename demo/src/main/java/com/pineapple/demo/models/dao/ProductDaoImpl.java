package com.pineapple.demo.models.dao;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements iProductDao {
	
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Product").getResultList();
	}

}
