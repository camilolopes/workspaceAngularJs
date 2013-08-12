package com.camilolopes.jersey.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camilolopes.jersey.domain.Customer;

@Repository
public class CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Customer customer){
		getSession().save(customer);
	}
	
	public List<Customer> listCustomer(){
		
		return  getSession().createCriteria(Customer.class).list();
	}
	
	public Session getSession(){
		
		return sessionFactory.openSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
