package com.fernandes.ecommercelovepet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Especie;
import com.fernandes.ecommercelovepet.repository.EspecieRepository;

@Service
public class EspecieService {
	
	@Autowired
	private EspecieRepository especieRepository;
	
	public List<Especie> findAll() {
		List<Especie> especies = especieRepository.findAll();
		
		return especies;
	}

}
