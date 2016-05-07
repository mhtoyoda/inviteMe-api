package br.com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.application.entity.EventType;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Integer>{

}
