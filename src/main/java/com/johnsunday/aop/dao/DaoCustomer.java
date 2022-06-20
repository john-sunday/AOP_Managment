package com.johnsunday.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class DaoCustomer {

	public void insertCustomer() {
		System.out.println("Customer inserted Successfully");
	}
}
