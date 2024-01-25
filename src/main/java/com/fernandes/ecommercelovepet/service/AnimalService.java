package com.fernandes.ecommercelovepet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Animal;
import com.fernandes.ecommercelovepet.repository.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public List<Animal> findAll() {
		List<Animal> animais = animalRepository.findAll();
		
		return animais;
	}

}
