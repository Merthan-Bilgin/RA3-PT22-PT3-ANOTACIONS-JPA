package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

//Profesor, es un tipo de Person
@Entity
@DiscriminatorValue("TEACHER") // Valor que se guarda en person_type para los profesores

public class Teacher extends Person {
	
	// Código del profesor
	@Column(name = "teacherCode")
	private String teacherCode;

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}
}
