package co.mz.cth.park.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import co.mz.cth.park.model.enums.Place;

@Entity
public class ParkPlace {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Enumerated
	private Place place;
    @OneToOne
	public Car car;
	
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	
	
}
