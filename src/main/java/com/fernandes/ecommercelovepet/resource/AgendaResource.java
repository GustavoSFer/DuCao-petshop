package com.fernandes.ecommercelovepet.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandes.ecommercelovepet.entities.Agenda;
import com.fernandes.ecommercelovepet.service.AgendaService;
import com.fernandes.ecommercelovepet.service.AnimalService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/agendas")
public class AgendaResource {

	@Autowired
	AgendaService agendaService;
	
	@GetMapping
	public ResponseEntity<List<Agenda>> findAll() {
		List<Agenda> agendas = agendaService.findAll();
		
		return ResponseEntity.ok().body(agendas);
	}
}
