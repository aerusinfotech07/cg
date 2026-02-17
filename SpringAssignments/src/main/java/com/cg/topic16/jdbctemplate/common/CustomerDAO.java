package com.cg.topic16.jdbctemplate.common;

import java.util.List;

public interface CustomerDAO 
{
	public void insert(Customer customer);
	
	public void insertNamedParameter(Customer customer);
			
	public void insertBatch(List<Customer> customer);
	
	public void insertBatchNamedParameter(List<Customer> customer);
	
	public void insertBatchNamedParameter2(List<Customer> customer);
			
	public void insertBatchSQL(String sql);
	
	public Customer findByCustomerId(int custId);
	
	public Customer findByCustomerId2(int custId);

	public List<Customer> findAll();
	
	public List<Customer> findAll2();
	
	public String findCustomerNameById(int custId);
	
	public int findTotalCustomer();
	
}




