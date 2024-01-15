package com.fernandes.ecommercelovepet.resource;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandes.ecommercelovepet.entities.Usuario;
import com.fernandes.ecommercelovepet.service.UsuarioService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService user;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> users = user.findAll();
		
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Usuario>> getById(@PathVariable Integer id) {
		Optional<Usuario> pessoa = user.findById(id);
		
		
		return ResponseEntity.ok().body(pessoa);
	}

}
