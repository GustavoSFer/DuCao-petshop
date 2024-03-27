package com.fernandes.ecommercelovepet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Agenda;
import com.fernandes.ecommercelovepet.repository.AgendaRepository;

@Service
public class AgendaService {
	
	@Autowired
	AgendaRepository agendaRepository;
	
	
	public List<Agenda> findAll() {
		List<Agenda> agendas = agendaRepository.findAll();
		
		return agendas;
	}

}
