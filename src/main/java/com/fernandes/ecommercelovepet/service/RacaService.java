package com.fernandes.ecommercelovepet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Raca;
import com.fernandes.ecommercelovepet.repository.RacaRepository;

@Service
public class RacaService {
	
	@Autowired
	private RacaRepository raca;
	
	
	public List<Raca> findAll() {
		List<Raca> racas = raca.findAll();
		
		return racas;
	}
	

}
