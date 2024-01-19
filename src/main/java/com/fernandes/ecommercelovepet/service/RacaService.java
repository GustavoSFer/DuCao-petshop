package com.fernandes.ecommercelovepet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Raca;
import com.fernandes.ecommercelovepet.repository.RacaRepository;
import com.fernandes.ecommercelovepet.service.exception.ResourceNotFound;

@Service
public class RacaService {
	
	@Autowired
	private RacaRepository racaService;
	
	
	public List<Raca> findAll() {
		List<Raca> racas = racaService.findAll();
		
		return racas;
	}
	
	public Raca findById(Integer id) {
		Optional<Raca> raca = racaService.findById(id);
		
		return raca.orElseThrow(() -> new ResourceNotFound());
	}

}
