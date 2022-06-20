package com.johnsunday.aop.dao;

import org.springframework.stereotype.Component;

import com.johnsunday.aop.main.Customer;

@Component
public class DaoCustomer {

	/*public void insertCustomer() {
		System.out.println("Customer inserted Successfully");
	}*/
	// Vídeo 79 - Pincut Expressions patterns.
	/*public String insertCustomer() {
		System.out.println("Operation OK. Normal Customer added");
		return "Customer inserted Successfully(DaoCustomer.class)";
	}*/
	public void insertCustomer(Customer customer,String customerType) {
		System.out.println("Operation OK. Normal Customer inserted Successfully");
	}
}
