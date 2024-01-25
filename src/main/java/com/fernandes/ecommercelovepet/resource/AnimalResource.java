package com.fernandes.ecommercelovepet.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandes.ecommercelovepet.entities.Animal;
import com.fernandes.ecommercelovepet.service.AnimalService;

@RestController
@RequestMapping(value = "/animais")
public class AnimalResource {
	
	@Autowired
	private AnimalService animalService;
	
	@GetMapping
	public ResponseEntity<List<Animal>> findAll() {
		List<Animal> animais = animalService.findAll();
		
		return ResponseEntity.ok().body(animais);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Animal> findById(@PathVariable Integer id) {
		Animal animal = animalService.findById(id);
		
		return ResponseEntity.ok().body(animal);
	}
}
