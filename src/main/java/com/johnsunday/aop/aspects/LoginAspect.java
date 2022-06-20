package com.johnsunday.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.johnsunday.aop.main.Customer;

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
	//@Before("execution(public void insert*())")
	
	
	// POINTCUT EXPRESSIONS PATTERNS
	
	//@Before("execution(public String insert*())")
	// DaoCustomer -> public STRING insertCustomer()
	// DaoVipCustomer -> public VOID insertVipCustomer()
	// Ejecuta SÓLO método STRING insert de Cliente NORMAL.
	
	//@Before("execution(public void insert*())")
	// DaoCustomer -> public STRING insertCustomer()
	// DaoVipCustomer -> public VOID insertVipCustomer()
	// Ejecuta SÓLO método VOID insert de Cliente VIP.
	
	//@Before("execution(public * insert*())")
	// Ejecuta TODOS los métodos VOID/TYPE insert de cualquier tipo de Cliente.
	
	//@Before("execution(public * insert*(com.johnsunday.aop.main.Customer))")
	// Before de método con parámetros(ruta a la clase especificando el paquete).
	// DaoCustomer -> public void insertCustomer(Customer customer) 
	// DaoVipCustomer -> public void insertVipCustomer()
	// Ejecuta SÓLO método insert con parámetro de tipo Customer.
	
	//@Before("execution(public * insert*(com.johnsunday.aop.main.Customer, ..))")
	// Ejecuta métodos insert con Customer como primer parámetro, 
	// y cualquier número de parámetros más de cualquier tipo.
	// .. -> comodín
	
	@Before("execution(public * insert*(..))")
	// Ejecuta métodos insert con cualquier número de parámetros 
	// de cualquier tipo.
	// .. -> comodín
	public void beforeInsertingCustomer() {
		/*	Estas son las taréas que se comprobarían antes de
		 * 	insertar el cliente.	*/
		System.out.println("The user is LOGGED IN");
		System.out.println("The profile to insert customers is CORRECT");
	}
}
