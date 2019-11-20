package co.mz.cth.park.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.mz.cth.park.model.User;

public interface IUser extends JpaRepository<User, String>{
 User findById(long id);
 
}
