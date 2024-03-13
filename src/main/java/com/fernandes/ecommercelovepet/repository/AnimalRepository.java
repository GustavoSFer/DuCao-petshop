package com.fernandes.ecommercelovepet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fernandes.ecommercelovepet.entities.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	
	 @Query("Select obj from Animal obj where obj.usuario.id = ?1")
	public List<Animal> findByUsuario(String id);

}
