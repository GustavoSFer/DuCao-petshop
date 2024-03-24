package com.fernandes.ecommercelovepet.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fernandes.ecommercelovepet.entities.AgendaBanhoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Agenda_banho")
public class AgendaBanho implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AgendaBanhoPK id;
	private boolean status;
	
	
	public AgendaBanho(Agenda agenda, Animal animal, boolean status) {
		super();
		id.setAgenda(agenda);
		id.setAnimal(animal);
		this.status = status;
	}

	public Agenda getAgenda() {
		return id.getAgenda();
	}
	
	public void setAgenda(Agenda agenda) {
		id.setAgenda(agenda);
	}
	
	public Animal getAnimal() {
		return id.getAnimal();
	}
	
	public void setAnimal(Animal animal) {
		id.setAnimal(animal);
	}

	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
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
		AgendaBanho other = (AgendaBanho) obj;
		return Objects.equals(id, other.id);
	}

}
