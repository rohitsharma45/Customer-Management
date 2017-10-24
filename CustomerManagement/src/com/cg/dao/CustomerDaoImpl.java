package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.cg.model.CustomerBean;

@Repository
@Transactional
public class CustomerDaoImpl implements ICustomerDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	public CustomerBean addDetails(CustomerBean cust){
		
		entityManager.persist(cust);
		entityManager.flush();
		
		return cust;
		
		
	}

	public CustomerBean displayById(String custNo) {
		
		CustomerBean customer=entityManager.find(CustomerBean.class, custNo);

		return customer;
	}

	@Override
	public List<CustomerBean> displayAll(CustomerBean cust) {
		String qStr = "SELECT cust FROM CustomerBean cust";
		TypedQuery<CustomerBean> query = entityManager.createQuery(qStr, CustomerBean.class);
		List<CustomerBean>  list=query.getResultList();
		return list;
	}
	
	
}
