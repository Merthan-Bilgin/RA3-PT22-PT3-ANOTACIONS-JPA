package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

//Coche, tipo concreto de Vehicle
@Entity
@Table(name = "car")
@PrimaryKeyJoinColumn(name = "id") // Usa la misma id que vehicle

public class Car extends Vehicle {

	// Número de puertas del coche
	@Column(name = "doors")
	private Integer doors;

	public Integer getDoors() {
		return doors;
	}

	public void setDoors(Integer doors) {
		this.doors = doors;
	}
}
