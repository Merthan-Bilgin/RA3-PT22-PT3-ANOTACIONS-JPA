package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

// Moto, tipo concreto de Vehicle
@Entity
@Table(name = "motorcycle")
@PrimaryKeyJoinColumn(name = "id") // Comparte id con vehicle
public class Motorcycle extends Vehicle {

	// Indica si la moto tiene sidecar
	@Column(name = "hasSidecar")
	private boolean hasSidecar;

	public boolean isHasSidecar() {
		return hasSidecar;
	}

	public void setHasSidecar(boolean hasSidecar) {
		this.hasSidecar = hasSidecar;
	}
}
