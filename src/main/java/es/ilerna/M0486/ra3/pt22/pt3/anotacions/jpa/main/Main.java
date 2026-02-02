package es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Car;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Motorcycle;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Person;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Plane;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Student;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Teacher;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Vehicle;

public class Main {

	// Listas que da la profesora (no se usan con Hibernate, pero no se pueden
	// borrar)
	private static List<Person> people = new ArrayList<>();
	private static List<Vehicle> vehicles = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcio;

		do {
			System.out.println("\n===== MENÚ PRINCIPAL =====");
			System.out.println("1) Fase 1: Crear datos de prueba");
			System.out.println("2) Fase 2: Quitar relación persona-vehículo");
			System.out.println("3) Fase 3: Actualizar un vehículo");
			System.out.println("0) Salir");
			System.out.print("Elige una opción: ");

			opcio = sc.nextInt();
			sc.nextLine();

			switch (opcio) {
			case 1:
				fase1();
				break;
			case 2:
				fase2();
				break;
			case 3:
				fase3();
				break;
			case 0:
				System.out.println("Cerrando aplicación...");
				break;
			default:
				System.out.println("Opción incorrecta.");
			}

		} while (opcio != 0);

		sc.close();
		HibernateSession.getSessionFactory().close(); // Cierra Hibernate (create-drop se ejecuta aquí)
	}


	// FASE 1: INSERTAR TODAS LAS PERSONAS Y VEHÍCULOS DEL ENUNCIADO
	
	private static void fase1() {

		// Abrimos sesión de Hibernate
		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		
		// CREACIÓN DE PERSONAS

		// Estudiantes
		Student s1 = new Student();
		s1.setName("Anna");
		s1.setSurname("Lopez");
		s1.setPhoneNumber(111111111);
		s1.setStudentCode("STU001");

		Student s2 = new Student();
		s2.setName("Jordi");
		s2.setSurname("Martinez");
		s2.setPhoneNumber(222222222);
		s2.setStudentCode("STU002");

		Student s3 = new Student();
		s3.setName("Clara");
		s3.setSurname("Sanchez");
		s3.setPhoneNumber(333333333);
		s3.setStudentCode("STU003");

		// Profesores
		Teacher t1 = new Teacher();
		t1.setName("Joan");
		t1.setSurname("Perez");
		t1.setPhoneNumber(444444444);
		t1.setTeacherCode("TEA001");

		Teacher t2 = new Teacher();
		t2.setName("Maria");
		t2.setSurname("Gomez");
		t2.setPhoneNumber(555555555);
		t2.setTeacherCode("TEA002");

		Teacher t3 = new Teacher();
		t3.setName("Pere");
		t3.setSurname("Ruiz");
		t3.setPhoneNumber(666666666);
		t3.setTeacherCode("TEA003");

		// Guardamos personas en la base de datos
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(t1);
		session.save(t2);
		session.save(t3);

		// CREACIÓN DE VEHÍCULOS

		// Coche 1
		Car car1 = new Car();
		car1.setBrand("Toyota");
		car1.setPrice(18000f);
		car1.setYear(2020);
		car1.setDoors(5);
		car1.setOwner(s1); // pertenece a persona 1

		// Coche 2
		Car car2 = new Car();
		car2.setBrand("Ford");
		car2.setPrice(15000f);
		car2.setYear(2019);
		car2.setDoors(3);
		car2.setOwner(t2); // pertenece a persona 5

		// Avión 1
		Plane plane1 = new Plane();
		plane1.setBrand("Cessna");
		plane1.setPrice(120000f);
		plane1.setYear(2015);
		plane1.setAutopilot(true);
		plane1.setTailNumber(11111);
		plane1.setOwner(t1); // pertenece a persona 4

		// Avión 2
		Plane plane2 = new Plane();
		plane2.setBrand("Boeing");
		plane2.setPrice(900000f);
		plane2.setYear(2010);
		plane2.setAutopilot(false);
		plane2.setTailNumber(22222);
		plane2.setOwner(s3); // pertenece a persona 3

		// Moto 1
		Motorcycle m1 = new Motorcycle();
		m1.setBrand("Yamaha");
		m1.setPrice(9000f);
		m1.setYear(2021);
		m1.setHasSidecar(false);
		m1.setOwner(s2); // pertenece a persona 2

		// Moto 2
		Motorcycle m2 = new Motorcycle();
		m2.setBrand("Harley-Davidson");
		m2.setPrice(20000f);
		m2.setYear(2018);
		m2.setHasSidecar(true);
		m2.setOwner(t3); // pertenece a persona 6

		// Guardamos vehículos
		session.save(car1);
		session.save(car2);
		session.save(plane1);
		session.save(plane2);
		session.save(m1);
		session.save(m2);

		tx.commit();
		session.close();

		System.out.println("Fase 1 completada: datos insertados correctamente.");
	}

	// FASE 2: QUITAR LA RELACIÓN ENTRE PERSONA 1 Y VEHÍCULO 1
	
	private static void fase2() {

		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		// Buscamos el vehículo con id = 1
		Vehicle v = session.get(Vehicle.class, 1);

		// Quitamos la relación (el vehículo ya no tiene dueño)
		v.setOwner(null);

		session.update(v);

		tx.commit();
		session.close();

		System.out.println("Fase 2 completada: el vehículo 1 ya no tiene propietario.");
	}

	// FASE 3: MODIFICAR LOS DATOS DEL VEHÍCULO 1

	private static void fase3() {

		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		// Buscamos el vehículo con id = 1
		Vehicle v = session.get(Vehicle.class, 1);

		// Actualizamos los datos según el enunciado
		v.setBrand("Seat");
		v.setPrice(19999f);
		v.setYear(2022);
		v.setOwner(null); // sigue sin propietario

		session.update(v);

		tx.commit();
		session.close();

		System.out.println("Fase 3 completada: el vehículo 1 ha sido actualizado.");
	}
}
