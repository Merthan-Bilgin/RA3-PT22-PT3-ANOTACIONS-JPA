package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*; // Vehículo genérico, clase base de Car, Plane y Motorcycle 

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED) // Herencia con tablas separadas unidas por la misma id

public abstract class Vehicle {
	// Clave primaria de la tabla vehicle
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	// Marca del vehículo
	@Column(name = "brand")
	private String brand;

	// Año del vehículo
	@Column(name = "year")
	private Integer year;

	// Precio del vehículo
	@Column(name = "price")
	private Float price;

	// Muchos vehículos pueden pertenecer a una persona
	@ManyToOne
	@JoinColumn(name = "person_id") // Columna FK en vehicle que apunta a person.id private Person owner;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	// Dueño del vehículo (persona)
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
}
