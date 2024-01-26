package com.fernandes.ecommercelovepet.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Animal> create(@RequestBody Animal animal) {
		Animal createAnimal = animalService.create(animal);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(animal.getId()).toUri();
		
		return ResponseEntity.created(uri).body(createAnimal);
	}
}
