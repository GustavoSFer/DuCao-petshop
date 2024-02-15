package com.fernandes.ecommercelovepet.dto;

import com.fernandes.ecommercelovepet.entities.Usuario;

public class UsuarioDTO {

	private Integer id;
	private String nome;
	private String cpf;
	private Integer telefone;
	private String email;
	private boolean administrador;
	
	public UsuarioDTO() {};
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		cpf = obj.getCpf();
		telefone = obj.getTelefone();
		email = obj.getEmail();
		administrador = obj.isAdministrador();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
}
