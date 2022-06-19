package pills.es.bean.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	/**
	 * ERROR GRAVE:
	 * Estuve varios días sin resolver el problema que me daba al intentar extraer de
	 * la bbdd los valores, porque los tipos estaban definidos como 'int' cuando eran
	 * String->varchar->name,surname y email.
	 * Por hacer COPY/PASTE...!!
	 */
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="email")
	private String email;
	
	// Constructors.
	public Customer() {
	}
	public Customer(String name, String surname, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	// Getters and Setters.
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}
}
