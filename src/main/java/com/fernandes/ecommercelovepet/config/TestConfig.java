package com.fernandes.ecommercelovepet.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernandes.ecommercelovepet.entities.Animal;
import com.fernandes.ecommercelovepet.entities.Especie;
import com.fernandes.ecommercelovepet.entities.Raca;
import com.fernandes.ecommercelovepet.entities.Usuario;
import com.fernandes.ecommercelovepet.repository.AnimalRepository;
import com.fernandes.ecommercelovepet.repository.EspecieRepository;
import com.fernandes.ecommercelovepet.repository.RacaRepository;
import com.fernandes.ecommercelovepet.repository.UsuarioRepository;

@Configuration
@Profile("MySql")
public class TestConfig implements CommandLineRunner {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RacaRepository raca;
	
	@Autowired
	private EspecieRepository especie;
	
	@Autowired
	private AnimalRepository animal;

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario("James Brown", "35812584584", 1144678521, true);
		Usuario cliente = new Usuario("Aurelina Silva Nega", "1129884569", 1144615814, false);
		
		usuarioRepository.saveAll(Arrays.asList(usuario, cliente));
		
		Raca viraLata = new Raca("Vira-lata");
		Raca pitbull = new Raca("pitbull");
		Raca chow = new Raca("Chow-Chow");
		
		raca.saveAll(Arrays.asList(viraLata, pitbull, chow));
		
		Especie cachorro = new Especie("Cachorro");
		
		especie.save(cachorro);
		
		Date data = sdf.parse("07/05/2020");
		Animal animal1 = new Animal("Slinky", 32.10, data , viraLata, cachorro, cliente);
		
		animal.save(animal1);
		
	}

}
