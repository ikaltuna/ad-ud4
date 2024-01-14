package ejercicios;

import java.time.LocalDate;

import entidades.Address;
import entidades.Course;
import entidades.Student;
import entidades.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Ud4TareaEvaluativa4cEjercicio1 {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud4");
	    EntityManager entityManager = factory.createEntityManager();
	    

	    
	    
	    try {			
			// crea un objeto Student y Course
			System.out.println("Creando un nuevo curso y añadiendo un alumno...");
			
			Student student = entityManager.find(Student.class, 6);
			Course course = createCourse();
			
			student.getCourses().add(course);
			course.getStudents().add(student);//asociación bidireccional para mantener la coherencia en ambos lados
			
			// comienza la transacci n
			entityManager.getTransaction().begin();
			
			// guarda el objeto University
			System.out.println("Guardando el curso...");
			entityManager.persist(course);
			
			// hace commit de la transaccion
			entityManager.getTransaction().commit();
			
			
			System.out.println("Hecho!");
		}
		catch ( Exception e ) {
			// rollback ante alguna excepción
			System.out.println("Realizando Rollback");
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
	}
	private static Course createCourse() {
		Course tempCourse = new Course();
				
		tempCourse.setName("Bases de datos");
		tempCourse.setCredits(6);
		return tempCourse;		
	}
}

