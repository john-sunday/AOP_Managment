package com.johnsunday.aop.dao;

import org.springframework.stereotype.Component;

import com.johnsunday.aop.main.Customer;

@Component
public class DaoCustomer {
	// Class Fields.
	private String normalCustomerFeedback;
	private String normalCustomerCode;
	// Getters and Setters.
	public String getNormalCustomerFeedback() {
		System.out.println("Getting customer FEEDBACK\n");
		return normalCustomerFeedback;
	}
	public void setNormalCustomerFeedback(String normalCustomerFeedback) {
		System.out.println("Setting customer FEEDBACK\n");
		this.normalCustomerFeedback = normalCustomerFeedback;
	}
	public String getNormalCustomerCode() {
		System.out.println("Getting customer CODE\n");
		return normalCustomerCode;
	}
	public void setNormalCustomerCode(String normalCustomerCode) {
		System.out.println("Setting customer CODE\n");
		this.normalCustomerCode = normalCustomerCode;
	}

	/*public void insertCustomer() {
		System.out.println("Customer inserted Successfully");
	}*/
	// Vídeo 79 - Pincut Expressions patterns.
	/*public String insertCustomer() {
		System.out.println("Operation OK. Normal Customer added");
		return "Customer inserted Successfully(DaoCustomer.class)";
	}*/
	public void insertCustomer(Customer customer,String customerType) {
		System.out.println("Operation OK. Normal Customer inserted Successfully\n");
	}
}
