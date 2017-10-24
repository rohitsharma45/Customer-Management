package com.cg.dao;

import java.util.List;

import com.cg.model.CustomerBean;


public interface ICustomerDao {

	public abstract CustomerBean addDetails(CustomerBean cust);



	CustomerBean displayById(String custNo);



	public abstract List<CustomerBean> displayAll(CustomerBean cust);
	
	
}
