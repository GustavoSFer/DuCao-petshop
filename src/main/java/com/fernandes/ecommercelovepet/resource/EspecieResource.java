package com.fernandes.ecommercelovepet.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandes.ecommercelovepet.entities.Especie;
import com.fernandes.ecommercelovepet.service.EspecieService;

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

}
