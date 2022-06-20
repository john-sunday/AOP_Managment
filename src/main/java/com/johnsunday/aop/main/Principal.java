package com.johnsunday.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.johnsunday.aop.dao.DaoCustomer;

public class Principal {

	public static void main(String[] args) {
		// Leer la configuración de Spring.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		// Obtener el bean del contenedor de Spring.
		DaoCustomer customer = context.getBean("daoCustomer",DaoCustomer.class);
		// Llamar al método.
		customer.insertCustomer();
		// Cerrar el contexto
		context.close();
	}
}
