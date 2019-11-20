package co.mz.cth.park.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.mz.cth.park.model.RoomDay;

public interface IRoomDay extends JpaRepository<RoomDay, String>{
	
	RoomDay findById(long id);

}
