package br.com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.application.entity.EventTypeAccess;

@Repository
public interface EventTypeAccessRepository extends JpaRepository<EventTypeAccess, Integer>{

}
