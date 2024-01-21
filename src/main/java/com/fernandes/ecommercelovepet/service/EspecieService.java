package com.fernandes.ecommercelovepet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Especie;
import com.fernandes.ecommercelovepet.repository.EspecieRepository;
import com.fernandes.ecommercelovepet.service.exception.CreateError;
import com.fernandes.ecommercelovepet.service.exception.ResourceNotFound;

@Service
public class EspecieService {
	
	@Autowired
	private EspecieRepository especieRepository;
	
	public List<Especie> findAll() {
		List<Especie> especies = especieRepository.findAll();
		
		return especies;
	}
	
	public Especie findById(Integer id) {
		Optional<Especie> especie = especieRepository.findById(id);
		
		return especie.orElseThrow(() -> new ResourceNotFound("Especie do id:" + id + " não encontrado!"));
	}
	
	public Especie create(Especie especie) {
		if (especie.getNome().isEmpty()) {
			throw new CreateError("Erro ao tentar criar a especie, verifique os parametros informados.");
		}
		
		especieRepository.save(especie);
		return especie;
	}

	public Especie update(Especie especie, Integer id) {
		Especie findEspecie = findById(id);
		if (!especie.getNome().isEmpty()) {
			findEspecie.setNome(especie.getNome());
		} else {
			throw new CreateError("Erro ao tentar atualizar a especie, verifique os parametros informados.");
		}
		especieRepository.save(findEspecie);
		return findEspecie;
	}
}
