package com.johnsunday.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class DaoVipCustomer {

	public void insertVipCustomer() {
		System.out.println("VIP customer inserted Successfully\n");
	}
}
