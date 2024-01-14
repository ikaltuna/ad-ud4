package ejercicios;

import entidades.Student;
import entidades.Tuition;
import entidades.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Ud4TareaEvaluativa4cEjercicio4 {




	/**
	 * 4. OneToOne unidireccional entre entidades Student y Tuition (matrícula).
	 * Borra un Tuition y su Student asociado
	 */
	public static void main(String[] args) {

		// crea EntityManager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud4");
	    EntityManager entityManager = factory.createEntityManager();
	    
	   
		
		try {			
		
			// Borra un objeto Student
			System.out.println("Borrando un objeto Student ");
						
			int student_id = 15;
			
			Student tempStudent = entityManager.find(Student.class, student_id);

			
			// comienza la transacción
			tempStudent.setId(student_id);
			entityManager.persist(tempStudent);
			
			entityManager.getTransaction().begin();
			
			// borra el objecto Student pero sin CascadeType.REMOVE no elimina el curso
			entityManager.remove(tempStudent);
						
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
}




