package com.fernandes.ecommercelovepet.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fernandes.ecommercelovepet.entities.Raca;
import com.fernandes.ecommercelovepet.service.RacaService;

@RestController
@RequestMapping(value = "/racas")
public class RacaResource {

	@Autowired
	private RacaService racaService;
	
	@GetMapping
	public ResponseEntity<List<Raca>> findAll() {
		List<Raca> racas = racaService.findAll();
		
		return ResponseEntity.ok().body(racas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Raca> findById(@PathVariable Integer id) {
		Raca raca = racaService.findById(id);
		
		return ResponseEntity.ok().body(raca);
	}
	
	@PostMapping
	public ResponseEntity<Raca> create(@RequestBody Raca raca) {
		Raca createRaca = racaService.create(raca);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(raca.getId()).toUri();
		
		return ResponseEntity.created(uri).body(createRaca);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Raca> update(@RequestBody Raca raca, @PathVariable Integer id) {
		Raca racaUpdate = racaService.update(raca, id);
		
		return ResponseEntity.ok().body(racaUpdate);
	}
	
}
