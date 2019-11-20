package co.mz.cth.park.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
@Entity
public class Room{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String type;
	
	
	@OneToMany(mappedBy="room")
	private List<RoomDay> roomday;
    // Este Atributo nao sera persistido(pelo jpa hibernate) nesta entidade
	@Transient
  	private List<LocalDate> days;

    public List<LocalDate> getDays() {
		
		return days;
	}


	public void setDays(List<LocalDate> days) {
		this.days = days;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<RoomDay> getRoomday() {
		return roomday;
	}


	public void setRoomday(List<RoomDay> roomday) {
		this.roomday = roomday;
	}
	
	
	
}
