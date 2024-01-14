package com.fernandes.ecommercelovepet.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandes.ecommercelovepet.entities.Usuario;
import com.fernandes.ecommercelovepet.service.UsuarioService;

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

}
