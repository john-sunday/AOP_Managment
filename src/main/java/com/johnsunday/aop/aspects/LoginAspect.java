package com.johnsunday.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
	
	// Reusable pointcut expression.
	//@Pointcut("execution(public * insert*(..))")

	@Pointcut("execution(* com.johnsunday.aop.dao.*.*(..))")
	// Poincut que actúa en el paquete indicado -> (*(espacio)com.johnsunday.aop.dao...)
	// sobre cualquier método -> .*.*
	// con/sin parámetros -> (..)
	// Nombre identificativo del pointcut expression.
	private void forCustomers() {}
	
	// Pointcut sólo para Getters.
	@Pointcut("execution(* com.johnsunday.aop.dao.*.get*(..))")
	private void forGetters() {}

	// Pointcut sólo para Setters.
	@Pointcut("execution(* com.johnsunday.aop.dao.*.set*(..))")
	private void forSetters() {}
	
	// Combinación de pointcuts.
	// Para todos los métodos, MENOS Getters y Setters.
	@Pointcut("forCustomers() && !(forGetters() || forSetters())")
	private void packageLessGettersSetters() {}
	
	//@Before("execution(public * insert*(..))")
	// Ejecuta métodos insert con cualquier número de parámetros 
	// de cualquier tipo.
	// .. -> comodín
	
	//@Before("forCustomers()")
	//@Before("forGetters()")// Ejecutamos método sólo antes de Getters->forGetters(){}
	//@Before("forSetters()")// Ejecutamos método sólo antes de Setters->forSetters(){}
	@Before("packageLessGettersSetters()")
	public void beforeInsertingCustomer() {
		/*	Estas son las taréas que se comprobarían antes de
		 * 	insertar el cliente.	*/
		System.out.println("The user is LOGGED IN");
		System.out.println("The profile to insert customers is CORRECT");
	}
	// Modularización para que el método 'beforeInsertingCustomer()'
	// no tenga 500!! líneas.
	
	//@Before("execution(public * insert*(..))")-> funciona pero si tienes 50 métodos, 
	// tienes que copiar y pegar 50 veces una expresión más compleja que con la reutilización.
	// @Before("execution(public * insert*(..))") -> más largo que -> @Before("forCustomers()")
	// Y sólo cambias el pointcut para cambiar las condiciones de la ejecución del pointcut.
	//@Before("forCustomers()")
	public void customerRequirements() {
		System.out.println("The customer meets the requirements to be added in DB");
	}
	
	// Si la tabla tiene más de 3.000 registros no se puede realizar la inserción.
	//@Before("execution(public * insert*(..))")
	
	//@Before("forCustomers()")
	public void tableRequirements() {
		System.out.println("There are less than 3.000 records in DB. You can add the new customer.");
	}
}
