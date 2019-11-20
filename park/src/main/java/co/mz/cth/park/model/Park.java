package co.mz.cth.park.model;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Park {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long id;
	private String dataStart;
	private String day;
	private String money;
	private String moneyAwaited;
	private LocalDate datafinal;
	@OneToMany(mappedBy = "park")
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
	public String getDataStart() {
		return dataStart;
	}
	public void setDataStart(String dataStart) {
		this.dataStart = dataStart;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getMoneyAwaited() {
		return moneyAwaited;
	}
	public void setMoneyAwaited(String moneyAwaited) {
		this.moneyAwaited = moneyAwaited;
	}
	public LocalDate getDatafinal() {
		return datafinal;
	}
	public void setDatafinal(LocalDate datafinal) {
		this.datafinal = datafinal;
	}
	
	
	
}
