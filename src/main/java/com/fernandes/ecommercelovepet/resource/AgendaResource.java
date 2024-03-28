package com.fernandes.ecommercelovepet.resource;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/abrirAgenda")
	public ResponseEntity<String> abrirAgenda(
			@RequestParam(value = "dataInicio") String dataInicio,
			@RequestParam(value = "dataFim") String dataFim,
			@RequestParam(value = "horaInicio") String horaInicio,
			@RequestParam(value = "horaFim") String horaFim,
			@RequestParam(value = "duracao") String duracao
			) {
		
		System.out.println(dataInicio);
		System.out.println(dataFim);
		//agendaService.abrirAgenda(dataInicio, dataFim, horaInicio, horaFim, duracao);
		
		return ResponseEntity.ok().body("Agenda aberta!");
	}
}
