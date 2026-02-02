package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // Esta clase se guarda en la BBDD
@Table(name = "person") // Nombre de la tabla
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Herencia en una sola tabla
@DiscriminatorColumn(name = "person_type") // Columna que indica si es Teacher o Student

public abstract class Person {
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
	@Column(name = "id") // Columna en la tabla
	private Integer id;

	@Column(name = "name") // Columna name
	private String name;

	@Column(name = "surname") // Columna surname
	private String surname;

	@Column(name = "phoneNumber") // Columna phoneNumber
	private Integer phoneNumber;

	// RELACIÓN 1 PERSONA -> MUCHOS VEHÍCULOS
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Vehicle> vehicles = new ArrayList<>();

	// MÉTODOS add/remove VEHICLE
	public void addVehicle(Vehicle v) {
		vehicles.add(v);
		v.setOwner(this);
	}

	public void removeVehicle(Vehicle v) {
		vehicles.remove(v);
		v.setOwner(null);
	}

	// GETTERS Y SETTERS

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
