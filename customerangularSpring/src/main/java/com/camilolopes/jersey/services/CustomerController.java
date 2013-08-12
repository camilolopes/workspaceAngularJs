package com.camilolopes.jersey.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.camilolopes.jersey.domain.Customer;
@Controller
@Path("/service")
public class CustomerController {
	@Autowired
	@Qualifier("customerService")
	private CustomerService customerService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCustomer() {
		List<Customer> list = customerService.getListCustomers();
		return list;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
