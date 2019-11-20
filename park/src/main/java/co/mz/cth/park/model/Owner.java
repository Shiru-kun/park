package co.mz.cth.park.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import co.mz.cth.park.model.Car;

@Entity
public class Owner{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	private Long id;
	@NotEmpty(message = "Enter name")
	private String name;
	@NotEmpty(message = "Enter telephone")
	private String telephone;
	@NotEmpty(message = "Enter Address")
	private String address;
	

	@OneToMany(mappedBy = "owner")
	private List<Car> car;


	public List<Car> getCar() {
		return car;
	}
	public void setCar(List<Car> car) {
		this.car = car;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
