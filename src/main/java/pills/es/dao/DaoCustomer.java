package pills.es.dao;

import java.util.List;

import pills.es.bean.entity.Customer;

public interface DaoCustomer {

	public List<Customer> getCustomers();
	// 5ºa - definimos método en Interface
	public void insertCustomer(Customer customer);
	// 3ºb - definimos método en Interface
	public Customer getCustomer(int id);
	// 3ºc
	public void deleteCustomer(int id);
}
