package com.fernandes.ecommercelovepet.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fernandes.ecommercelovepet.entities.Especie;
import com.fernandes.ecommercelovepet.service.EspecieService;
import com.fernandes.ecommercelovepet.util.ResponseMessages;

@RestController
@RequestMapping(value = "/especies")
public class EspecieResource {
	
	@Autowired
	private EspecieService especieService;
	
	@GetMapping
	public ResponseEntity<List<Especie>> findAll() {
		List<Especie> especies = especieService.findAll();
		
		return ResponseEntity.ok().body(especies);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Especie> findById(@PathVariable Integer id) {
		Especie especie = especieService.findById(id);
		
		return ResponseEntity.ok().body(especie);
	}
	
	@PostMapping
	public ResponseEntity<Especie> create(@RequestBody Especie especie) {
		Especie novaEspecie = especieService.create(especie);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(especie.getId()).toUri();		
		return ResponseEntity.created(uri).body(novaEspecie);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Especie> create(@RequestBody Especie especie, @PathVariable Integer id) {
		Especie updateEspecie = especieService.update(especie, id);

		return ResponseEntity.ok().body(updateEspecie);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseMessages> delete(@PathVariable Integer id) {
		ResponseMessages deletado = especieService.delete(id);
		
		return ResponseEntity.ok().body(deletado);
	}
}
