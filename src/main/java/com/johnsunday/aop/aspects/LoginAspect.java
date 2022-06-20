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
	 * ANTES de que se ejecute el método insertCustomer() qué esté en cualquier
	 * clase.	*/
	//@Before("execution(public void insertCustomer())")
	
	// Pointcut expression 1.
	/*	Aplica el aspecto, sólo a la ruta que le indiquemos. 
	 * 	En este caso, sólo a la clase DaoVipCustomer.	*/
	//@Before("execution(public void com.johnsunday.aop.dao.DaoVipCustomer.insertCustomer())")
	
	// Pointcut expression 2.
	/*	Para aplicar el aspecto con patrones, porque los métodos se llaman de 
	 * 	manera diferente.	*/
	@Before("execution(public void insert*())")
	public void beforeInsertingCustomer() {
		/*	Estas son las taréas que se comprobarían antes de
		 * 	insertar el cliente.	*/
		System.out.println("The user is LOGGED IN");
		System.out.println("The profile to insert customers is CORRECT");
	}
}
