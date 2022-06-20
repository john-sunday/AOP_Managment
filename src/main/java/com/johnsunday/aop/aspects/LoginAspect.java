package com.johnsunday.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Indicamos que esta clase es un ASPECTO.
@Aspect
// Indicamos que esta clase es un COMPONENTE.
@Component
public class LoginAspect {
	
	/* Indicamos que queremos ejecutar el método 'beforeInsertingCustomer()'
	 * ANTES de que se ejecute el método insertCustomer()	*/
	@Before("execution(public void insertCustomer())")
	public void beforeInsertingCustomer() {
		/*	Estas son las taréas que se comprobarían antes de
		 * 	insertar el cliente.	*/
		System.out.println("The user is LOGGED IN");
		System.out.println("the profile to insert customers is CORRECT");
	}
}
