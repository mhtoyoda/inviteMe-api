package br.com.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.application.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer>{

}
