package com.fernandes.ecommercelovepet.resource;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fernandes.ecommercelovepet.entities.Usuario;
import com.fernandes.ecommercelovepet.service.UsuarioService;
import com.fernandes.ecommercelovepet.util.ResponseMessages;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
	public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
		Usuario pessoa = user.findById(id);
		
		return ResponseEntity.ok().body(pessoa);
	}
	
	@GetMapping(params = "email")
	public ResponseEntity<Usuario> getByEmail(@RequestParam String email, @RequestParam String senha) {
		Usuario pessoa = user.findByEmail(email, senha);
		
		return ResponseEntity.ok().body(pessoa);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario pessoa) {
		System.out.println(pessoa);
		Usuario pessoaCriada = user.create(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).body(pessoaCriada);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario pessoa) {
		Usuario pessoaAtualizada = user.update(id, pessoa);
		
		return ResponseEntity.ok().body(pessoaAtualizada);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseMessages> delete(@PathVariable Integer id) {
		user.delete(id);
		ResponseMessages deletado = new ResponseMessages(true, "Usuario deletado com sucesso!", id);
		
		return ResponseEntity.ok().body(deletado);
	}

}
