package br.com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.application.entity.StatusType;

@Repository
public interface StatusTypeRepository extends JpaRepository<StatusType, Integer>{

}
