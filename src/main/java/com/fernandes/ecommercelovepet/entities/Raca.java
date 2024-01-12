package com.fernandes.ecommercelovepet.entities;

import java.io.Serializable;
import java.util.Objects;

public class Raca implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public Raca() {}

	public Raca(String nome) {
		super();
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Raca other = (Raca) obj;
		return Objects.equals(id, other.id);
	};
	
	
}
