package ejercicios;

import entidades.Student;
import entidades.Tuition;
import entidades.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Ud4TareaEvaluativa4bEjercicio4 {




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
		
			System.out.println("Borrando una universidad sin borrar sus estudiantes");
			
			int university_id = 9;
			
			University tempUniversity = entityManager.find(University.class, university_id);

			tempUniversity.setId(university_id);
			entityManager.persist(tempUniversity);
			
			// borra la universidad pero no el estudiante. "on delete set null" en BD
			entityManager.remove(tempUniversity);
			
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




