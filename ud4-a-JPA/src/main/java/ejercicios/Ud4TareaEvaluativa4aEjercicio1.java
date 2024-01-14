package ejercicios;

import java.time.LocalDate;

import entidades.Address;
import entidades.Student;
import entidades.Tuition;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Ud4TareaEvaluativa4aEjercicio1 {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud4");
	    EntityManager entityManager = factory.createEntityManager();
	    
	    entityManager.getTransaction().begin();
	    
	    
	    try {			
			// crea un objeto Student
			System.out.println("Creando un nuevo objeto Student con su direcci�n y matr�cula (tuition)");
			Student student = createStudent();
			Tuition tuition = new Tuition();
			tuition.setFee(4000.00);
			student.setTuition(tuition);					

			
			//guarda el Student y con CascadeType.ALL guarda tambi�n el Tuition
			System.out.println("Guardando el estudiante...");
		
			
			entityManager.persist(student);
			
			// hace commit de la transaccion
			entityManager.getTransaction().commit();
					
			System.out.println("Hecho!");
		}
		catch ( Exception e ) {
			// rollback ante alguna excepci�n
			System.out.println("Realizando Rollback");
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
	}
	private static Student createStudent() {
		Student tempStudent = new Student();
		Address tempAddress = new Address();
		
		tempStudent.setFirstName("I�aki");
		tempStudent.setLastName("Laspiur");
		tempStudent.setEmail("ilaspiur@birt.eus");
		tempStudent.getPhones().add("687123456");
		tempStudent.getPhones().add("699212345");
		tempStudent.setBirthdate(LocalDate.parse("1985-04-04"));
		tempAddress.setAddressLine1("Burdin kale 8");
		tempAddress.setAddressLine2("1A");
		tempAddress.setCity("Zarautz");
		tempAddress.setZipCode("20080");
		tempStudent.setAddress(tempAddress);
		return tempStudent;		
	}
}

