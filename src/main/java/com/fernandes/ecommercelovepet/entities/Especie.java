package com.fernandes.ecommercelovepet.entities;

import java.io.Serializable;
import java.util.Objects;

public class Especie implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public Especie() {}

	public Especie(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Especie other = (Especie) obj;
		return Objects.equals(id, other.id);
	};
	
	

}
