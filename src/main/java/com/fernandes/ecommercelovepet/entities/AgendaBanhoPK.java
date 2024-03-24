package com.fernandes.ecommercelovepet.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class AgendaBanhoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name = "agenda_id")
	private Agenda agenda;
	
	@OneToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agenda, animal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendaBanhoPK other = (AgendaBanhoPK) obj;
		return Objects.equals(agenda, other.agenda) && Objects.equals(animal, other.animal);
	}
	
	
}
