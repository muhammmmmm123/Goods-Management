/**
 * 客户服务类
 */
package com.njupt.mis.services;

import java.util.Vector;

import com.njupt.mis.dao.CustomerDAO;
import com.njupt.mis.handler.CustomerServicesHandler;
import com.njupt.mis.model.Customer;
 
public class CustomerServices implements CustomerServicesHandler
{
	CustomerDAO customerDAO=null;
	
	public CustomerServices()
	{
		super();
	}

	
	public boolean addCustomer(Customer customer)
	{
		customerDAO=new CustomerDAO();
		return customerDAO.addCustomer(customer);
	}

	
	public boolean deleteCustomer(String id)
	{
		customerDAO=new CustomerDAO();
		return customerDAO.deleteCustomer(id);
		
	}

	
	public boolean modifyCustomer(Customer customer)
	{
		customerDAO=new CustomerDAO();
		return customerDAO.modifyCustomer(customer);
	}

	
	public Vector<Customer> getAllCustomer()
	{
		customerDAO=new CustomerDAO();
		return customerDAO.getAllCustomer();
	}

	
	public Vector<Customer> searchCustomer(String field, String value)
	{
		customerDAO=new CustomerDAO();
		return customerDAO.searchCustomer(field, value);
	}

	
	public boolean isExited(String id)
	{
		customerDAO=new CustomerDAO();
		return customerDAO.isExited(id);
	}

	
	public Customer getCustomerInfo(String id)
	{
		customerDAO=new CustomerDAO();
		return customerDAO.getCustomerInfo(id);
	}


}
