package com.fernandes.ecommercelovepet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandes.ecommercelovepet.entities.Usuario;
import com.fernandes.ecommercelovepet.repository.UsuarioRepository;
import com.fernandes.ecommercelovepet.service.exception.CreateError;
import com.fernandes.ecommercelovepet.service.exception.ResourceNotFound;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository user;

	public List<Usuario> findAll() {
		List<Usuario> usuarios = user.findAll();

		return usuarios;
	}

	public Usuario findById(Integer id) {
		Optional<Usuario> pessoa = user.findById(id);

		return pessoa.orElseThrow(() -> new ResourceNotFound("Pessoa não encontrada!"));
	}

	public Usuario create(Usuario pessoa) {
		String msg = verificaAtributos(pessoa);
		if (msg != null) {
			throw new CreateError(msg);
		}
		Usuario createUser = user.save(pessoa);
		return createUser;
	}

	private String verificaAtributos(Usuario pessoa) {
		
		if (pessoa.getNome() == null) {
			return "Nome esta vazio";
		} else if (pessoa.getCpf() == null) {
			return "CPF esta vazio";
		} else if (pessoa.getTelefone() == null) {
			return "Telefone está vazio";
		}
		
		return null;		
	}

	public Usuario update(Integer id, Usuario pessoa) {
		Usuario encontrarPessoas = findById(id);
		AtualizaCadastro(pessoa, encontrarPessoas);
		
		user.save(encontrarPessoas);
		
		return encontrarPessoas;		
	}
	
	private void AtualizaCadastro(Usuario pessoa, Usuario pessoaBanco) {
		pessoaBanco.setNome(pessoa.getNome());
		pessoaBanco.setCpf(pessoa.getCpf());
		pessoaBanco.setTelefone(pessoa.getTelefone());
	}
	
	public void delete(Integer id) {
		Usuario encontrarPessoas = findById(id);
		user.delete(encontrarPessoas);
	}
}
