package co.mz.cth.park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.mz.cth.park.model.Room;
@Repository
public interface IRoom extends JpaRepository<Room, String>{
	
	Room findById(long id);
	
	

}
