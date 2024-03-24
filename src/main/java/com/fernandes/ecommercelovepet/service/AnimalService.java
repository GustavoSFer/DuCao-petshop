package com.fernandes.ecommercelovepet.service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Animal;
import com.fernandes.ecommercelovepet.repository.AnimalRepository;
import com.fernandes.ecommercelovepet.service.exception.CreateError;
import com.fernandes.ecommercelovepet.service.exception.ResourceNotFound;
import com.fernandes.ecommercelovepet.util.ResponseMessages;

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
	
	public Animal create(Animal animal) {
		boolean isValid = verificaDadosAnimal(animal);
		if (!isValid) {
			throw new CreateError("Dados passado invalido. Verifique as informações passadas");
		}
		animalRepository.save(animal);
		
		return animal;
	}
	
	private boolean verificaDadosAnimal(Animal animal) {
		boolean isValid = true;

		if (animal.getNome().isEmpty() || animal.getEspecie().getId() == null || animal.getRaca().getId() == null || animal.getNascimento().toString() == "") {
			isValid = false;
		}
		return isValid;
	}
	
	public Animal update(Animal animal , Integer id) {
		Animal findByAnimal = findById(id);
		atualizaDadoAnimal(animal, findByAnimal);
		
		animalRepository.save(findByAnimal);
		
		return findByAnimal;
	}
	
	private void atualizaDadoAnimal(Animal animal, Animal update) {
		update.setNome(animal.getNome());
		update.setNascimento(animal.getNascimento());
		update.setPeso(animal.getPeso());
		update.setRaca(animal.getRaca());
		update.setEspecie(animal.getEspecie());
		update.setUsuario(animal.getUsuario());
	}
	
	public ResponseMessages delete(Integer id) {
		Animal animal = findById(id);
		
		animalRepository.delete(animal);
		
		ResponseMessages statusDelete = new ResponseMessages(true, "Animal deletado com sucesso", id);
		
		return statusDelete;
	}
	
	public List<Animal> findByAnimalUsuario(String id) {
		List<Animal> animais = animalRepository.findByUsuario(id);
		
		return animais;
	}
}
