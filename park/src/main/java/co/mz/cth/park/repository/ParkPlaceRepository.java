package co.mz.cth.park.repository;

import org.springframework.data.repository.CrudRepository;

import co.mz.cth.park.model.ParkPlace;

public interface ParkPlaceRepository extends CrudRepository<ParkPlace, String>{
ParkPlace findById(long id);
}
