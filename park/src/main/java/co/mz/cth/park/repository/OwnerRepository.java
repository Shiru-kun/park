package co.mz.cth.park.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.mz.cth.park.model.Car;
import co.mz.cth.park.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, String> {
	Owner findById(long id); // Para procura de um elemento por codigo
Iterable<Owner> findByCar(Car car);
}
