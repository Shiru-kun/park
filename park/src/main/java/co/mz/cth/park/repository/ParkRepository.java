package co.mz.cth.park.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.mz.cth.park.model.Park;

@Repository
public interface ParkRepository  extends CrudRepository<Park, String> {
	Park findById(long id); 
}
