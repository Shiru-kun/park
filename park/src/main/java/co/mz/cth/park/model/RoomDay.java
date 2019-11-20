package co.mz.cth.park.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class RoomDay {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private LocalDate localdt;
 
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Room room;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getLocaldt() {
		return localdt;
	}

	public void setLocaldt(LocalDate localdt) {
		this.localdt = localdt;
	}
    	
	
}
