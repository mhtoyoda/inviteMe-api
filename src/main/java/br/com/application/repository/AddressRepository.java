package br.com.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.application.entity.AddressEvent;

@Repository
public interface AddressRepository extends CrudRepository<AddressEvent, Integer>{

}
