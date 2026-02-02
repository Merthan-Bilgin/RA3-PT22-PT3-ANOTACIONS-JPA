package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

//Estudiante, también es un tipo de Person
@Entity
@DiscriminatorValue("STUDENT") // Valor que se guarda en person_type para los estudiantes

public class Student extends Person {
	// Código del estudiante
	@Column(name = "studentCode")
	private String studentCode;

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
}
