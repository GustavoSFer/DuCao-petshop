package com.fernandes.ecommercelovepet.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernandes.ecommercelovepet.entities.Usuario;
import com.fernandes.ecommercelovepet.repository.UsuarioRepository;

@Configuration
@Profile("MySql")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario("James Brown", "35812584584", 1144678521, true);
		Usuario cliente = new Usuario("Aurelina Silva Nega", "1129884569", 1144615814, false);
		
		usuarioRepository.saveAll(Arrays.asList(usuario, cliente));
		
	}

}
