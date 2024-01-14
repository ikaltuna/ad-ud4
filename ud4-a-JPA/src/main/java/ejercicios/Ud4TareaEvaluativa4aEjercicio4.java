package ejercicios;

import entidades.Student;
import entidades.Tuition;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Ud4TareaEvaluativa4aEjercicio4 {




	/**
	 * 4. OneToOne unidireccional entre entidades Student y Tuition (matrícula).
	 * Borra un Tuition y su Student asociado
	 */
	public static void main(String[] args) {

		// crea EntityManager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud4");
	    EntityManager entityManager = factory.createEntityManager();
	    
	    entityManager.getTransaction().begin();
		
		try {			
		
			System.out.println("Borrando un nuevo Student y en cascada su Tuition asociado");
			
			
			
			
			int student_id = 14;
			
			Student tempStudent = entityManager.find(Student.class, student_id);

			tempStudent.setId(student_id);
			entityManager.persist(tempStudent);
			
			
		
			
			// borra el Student y con CascadeType.ALL termina borrando su Tuition
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




