package com.fernandes.ecommercelovepet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fernandes.ecommercelovepet.entities.Animal;
import com.fernandes.ecommercelovepet.repository.AnimalRepository;

public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public List<Animal> findAll() {
		List<Animal> animais = animalRepository.findAll();
		
		return animais;
	}

}
