package com.fernandes.ecommercelovepet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernandes.ecommercelovepet.entities.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
