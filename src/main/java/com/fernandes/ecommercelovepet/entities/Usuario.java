package com.fernandes.ecommercelovepet.entities;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String cpf;
	private int telefone;
	private boolean administrador;
	
	
	public Usuario() {}


	public Usuario(String nome, String cpf, int telefone, boolean administrador) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.administrador = administrador;
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


	public int getTelefone() {
		return telefone;
	}


	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}


	public boolean isAdministrador() {
		return administrador;
	}


	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}


	public Integer getId() {
		return id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	};
	
	
}
