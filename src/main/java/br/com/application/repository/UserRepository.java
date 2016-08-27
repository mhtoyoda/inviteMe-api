package br.com.application.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.application.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer>{

	@Query("FROM Users WHERE email = :email and password = :password")
	Users findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
