package br.com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.application.entity.SocialType;

@Repository
public interface SocialTypeRepository extends JpaRepository<SocialType, Integer>{

}
