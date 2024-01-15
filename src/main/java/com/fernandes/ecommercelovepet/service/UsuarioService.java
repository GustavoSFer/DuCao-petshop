package com.fernandes.ecommercelovepet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Usuario;
import com.fernandes.ecommercelovepet.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository user;
	
	public List<Usuario> findAll() {
		List<Usuario> usuarios = user.findAll();
		
		return usuarios;
	}
	
	public Optional<Usuario> findById(Integer id) {
		Optional<Usuario> pessoa = user.findById(id);
		
		return pessoa;
	}
	
}
