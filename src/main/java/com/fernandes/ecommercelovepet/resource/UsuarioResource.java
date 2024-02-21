package com.fernandes.ecommercelovepet.resource;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fernandes.ecommercelovepet.dto.UsuarioDTO;
import com.fernandes.ecommercelovepet.entities.Usuario;
import com.fernandes.ecommercelovepet.service.UsuarioService;
import com.fernandes.ecommercelovepet.util.PasswordEncode;
import com.fernandes.ecommercelovepet.util.ResponseMessages;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService user;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> users = user.findAll();
		List<UsuarioDTO> usersDTO = users.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(usersDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
		Usuario pessoa = user.findById(id);
		
		return ResponseEntity.ok().body(pessoa);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> getByEmail(@RequestParam(value = "email") String email, @RequestParam(value = "senha") String senha) {
		Usuario pessoa = user.findByEmail(email, senha);
		
		return ResponseEntity.ok().body(pessoa);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario pessoa) {

		String encoderSenha = PasswordEncode.encoder(pessoa.getSenha());
		pessoa.setSenha(encoderSenha);
		
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
