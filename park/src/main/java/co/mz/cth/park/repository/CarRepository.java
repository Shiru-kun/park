package co.mz.cth.park.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.mz.cth.park.model.Car;
// criteria 
// 
public interface CarRepository extends JpaRepository<Car,String>{
Car findById(long id);


//@Query(nativeQuery = true, value="select * from owner inner join car on car.owner_id= :owner.id")

}
