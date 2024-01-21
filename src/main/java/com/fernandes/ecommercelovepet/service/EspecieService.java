package com.fernandes.ecommercelovepet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Especie;
import com.fernandes.ecommercelovepet.repository.EspecieRepository;
import com.fernandes.ecommercelovepet.service.exception.ResourceNotFound;

@Service
public class EspecieService {
	
	@Autowired
	private EspecieRepository especieRepository;
	
	public List<Especie> findAll() {
		List<Especie> especies = especieRepository.findAll();
		
		return especies;
	}
	
	public Especie findById(Integer id) {
		Optional<Especie> especie = especieRepository.findById(id);
		
		return especie.orElseThrow(() -> new ResourceNotFound("Especie do id:" + id + " não encontrado!"));
	}

}
