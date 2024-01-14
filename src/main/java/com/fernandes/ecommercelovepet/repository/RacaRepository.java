package com.fernandes.ecommercelovepet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernandes.ecommercelovepet.entities.Raca;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Integer> {

}
