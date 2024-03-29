package com.fernandes.ecommercelovepet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernandes.ecommercelovepet.entities.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {
	
}
