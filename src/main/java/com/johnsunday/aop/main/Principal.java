package com.johnsunday.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.johnsunday.aop.dao.DaoCustomer;
import com.johnsunday.aop.dao.DaoVipCustomer;

public class Principal {

	public static void main(String[] args) {
		// Leer la configuración de Spring.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		// Obtener el bean del contenedor de Spring.
		DaoCustomer customer = context.getBean("daoCustomer",DaoCustomer.class);
		DaoVipCustomer vipCustomer = context.getBean("daoVipCustomer",DaoVipCustomer.class);
		// Llamar al método.
		customer.insertCustomer(new Customer("juanon","normal"),"NORMAL");
		vipCustomer.insertVipCustomer();
		// Cerrar el contexto
		context.close();
	}
}
