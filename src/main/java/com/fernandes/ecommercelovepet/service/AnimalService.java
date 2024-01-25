package com.fernandes.ecommercelovepet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Animal;
import com.fernandes.ecommercelovepet.repository.AnimalRepository;
import com.fernandes.ecommercelovepet.service.exception.ResourceNotFound;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public List<Animal> findAll() {
		List<Animal> animais = animalRepository.findAll();
		
		return animais;
	}
	
	public Animal findById(Integer id) {
		Optional<Animal> animal = animalRepository.findById(id);
		
		return animal.orElseThrow(() -> new ResourceNotFound("Animal com o id: " + id + " não encontrado."));
	}

}
