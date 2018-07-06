package com.raq.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.raq.mongo.bo.CustomerBO;
import com.raq.mongo.dao.CustomerRepository;
import com.raq.mongo.vo.Customer;

@SpringBootApplication
public class DemoMongoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	

	@Autowired
	private CustomerBO customerBO;

	public static void main(String[] args) {
		SpringApplication.run(DemoMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerBO.removeAllCustomers();
		customerBO.createCustomer(new Customer("Alice", "Smith"));
		customerBO.createCustomer(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerBO.findAllCustomers()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}

	}

}