package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("TEACHER") // Valor que se guardará en la columna person_type

public class Teacher extends Person {
	@Column(name = "teacherCode")
	private String teacherCode;

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}
}
