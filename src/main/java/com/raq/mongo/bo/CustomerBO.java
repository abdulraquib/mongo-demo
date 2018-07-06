package com.raq.mongo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raq.mongo.dao.CustomerRepository;
import com.raq.mongo.vo.Customer;

@Component
public class CustomerBO {

	@Autowired
	private CustomerRepository repository;

	
	public void createCustomer(Customer customer){
		repository.save(customer);
	}
	
	public void createCustomers(List<Customer> customers) {
		repository.saveAll(customers);
		
	}
	
	public List<Customer> findAllCustomers(){
		return repository.findAll();
	}
	
	public void removeCustomer(Customer customer) {
		repository.delete(customer);
	}
	
	public void removeAllCustomers() {
		repository.deleteAll();
	}
	
}
