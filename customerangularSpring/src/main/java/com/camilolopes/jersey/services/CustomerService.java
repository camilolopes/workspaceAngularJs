package com.camilolopes.jersey.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.jersey.dao.CustomerDAO;
import com.camilolopes.jersey.domain.Customer;

@Service
public class CustomerService {
	@Autowired
	@Qualifier("customerDAO")
	private CustomerDAO customerDAO;
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Customer>getListCustomers(){
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("Camilo Lopes");
//		List list = new ArrayList<Customer>();
//		list.add(customer);
		List<Customer> list = customerDAO.listCustomer();
		return list;
	}
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	@Transactional
	public void save(Customer customer) {
		customerDAO.save(customer);
		
	}
}
