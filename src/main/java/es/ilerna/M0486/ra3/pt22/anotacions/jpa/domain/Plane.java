package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

// Avión, tipo concreto de Vehicle
@Entity
@Table(name = "plane")
@PrimaryKeyJoinColumn(name = "id") // Comparte id con vehicle
public class Plane extends Vehicle {

	// Número de cola del avión
	@Column(name = "tailNumber")
	private Integer tailNumber;

	// Número de asientos
	@Column(name = "seats")
	private Integer seats;

	// Indica si tiene piloto automático
	@Column(name = "autopilot")
	private boolean autopilot;

	public Integer getTailNumber() {
		return tailNumber;
	}

	public void setTailNumber(Integer tailNumber) {
		this.tailNumber = tailNumber;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public boolean isAutopilot() {
		return autopilot;
	}

	public void setAutopilot(boolean autopilot) {
		this.autopilot = autopilot;
	}
}
