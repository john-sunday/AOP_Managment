package pills.es.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pills.es.bean.entity.Customer;
import pills.es.dao.DaoCustomer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Dependency Injection -> 'DaoCustomer' injected in 'CustomerController'
	@Autowired
	private DaoCustomer daoCustomer;
	
	@RequestMapping("/customerList")
	public String showCustomerList(Model model) {
		// To get the customers from DAO.
		List<Customer> customers = daoCustomer.getCustomers();
		// Agregate the customer to model.
		// addAttribute(key,value)
		model.addAttribute("customers",customers);
		
		return "customer_list";
	}
	//--------------------------------------------------------------------------------
	// 2ºa - mostramos formulario para AGREGAR cliente.
	@RequestMapping("/showAggregateForm")
	public String showAggregateForm(Model model) {
		// Bind customer data.
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		return "customer_add_update_form";
	}	
	// 4ºa - datos de cliente introducidos en formulario, son guardados en bbdd.
	// 4ºa - redirigimos a la lista de clientes
	// Mapping al formulario de inserción en customer_aggregate_form.jsp
	@PostMapping("/insertCustomer")
	public String insertCustomer(@ModelAttribute("customer") Customer customer) {
		// Insert customer in DB.
		daoCustomer.insertCustomer(customer);
		return "redirect:/customer/customerList";
	}
	//--------------------------------------------------------------------------------	
	// 2ºb - se recoge dato 'id' de cliente.
	// 2ºb - devolvemos flujo al formulario.
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("customerId")int id, Model model) {
		// Obtener el customer.
		Customer customer = daoCustomer.getCustomer(id);
		// Establecer el customer como atributo del modelo.
		model.addAttribute("customer",customer);
		// Enviar al mismo formulario que agrega.				
		return "customer_add_update_form";
	}
	//--------------------------------------------------------------------------------
	// 2ºc
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId")int id) {
		// Eliminar el cliente.
		daoCustomer.deleteCustomer(id);
		// Mostrar la lista actualizada de los clientes.				
		return "redirect:/customer/customerList";
	}
}
