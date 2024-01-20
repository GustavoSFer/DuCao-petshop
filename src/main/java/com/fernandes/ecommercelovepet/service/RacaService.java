package com.fernandes.ecommercelovepet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Raca;
import com.fernandes.ecommercelovepet.repository.RacaRepository;
import com.fernandes.ecommercelovepet.service.exception.CreateError;
import com.fernandes.ecommercelovepet.service.exception.ResourceNotFound;

@Service
public class RacaService {
	
	@Autowired
	private RacaRepository racaRepository;
	
	
	public List<Raca> findAll() {
		List<Raca> racas = racaRepository.findAll();
		
		return racas;
	}
	
	public Raca findById(Integer id) {
		Optional<Raca> raca = racaRepository.findById(id);
		
		return raca.orElseThrow(() -> new ResourceNotFound("Raça não encontrada!"));
	}
	
	public Raca create(Raca raca) {
		if (raca.getNome().isEmpty()) {
			throw new CreateError("Nome da raca está em branco");
		}
			
		Raca createRaca = racaRepository.save(raca);
		return createRaca;
	}
	
	public Raca update(Raca raca, Integer id) {
		Raca findRaca = findById(id);
		updateRaca(findRaca, raca);
		racaRepository.save(findRaca);
		
		return findRaca;
	}
	
	private void updateRaca(Raca findRaca, Raca raca) {
		findRaca.setNome(raca.getNome());
	}
	
	public void Delete(Integer id) {
		Raca deletaRaca = findById(id);
		
		racaRepository.delete(deletaRaca);
	}

}
