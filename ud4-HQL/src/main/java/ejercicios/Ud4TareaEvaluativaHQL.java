package ejercicios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import entidades.Student;
import entidades.University;

public class Ud4TareaEvaluativaHQL {

	/**
	 * 1. Crea un nuevo objeto Student y guárdalo en la base de datos
	 */
	public static void main(String[] args) {

		// crea sessionFactory y session
				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
						.configure( "hibernate.cfg.xml" )
					    .build();

				Metadata metadata = new MetadataSources( standardRegistry )
						.addAnnotatedClass( Student.class )
						.addAnnotatedClass( University.class )
					    .getMetadataBuilder()
					    .build();

				SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
						.build();    
				
				Session session = sessionFactory.openSession();
		
		try {			
			
			// comienza la transacción
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			
			displayStudentsUniversity(theStudents,session);
			
			System.out.println("Hecho!");
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	private static void displayStudentsUniversity(List<Student> theStudents, Session session) {
		for(Student tempStudent : theStudents) {
			System.out.print(tempStudent.getFirstName() + " " +  tempStudent.getLastName() + " ");
			if(tempStudent.getUniversity() != null) {
				University tempUniversity = tempStudent.getUniversity();
				System.out.println(tempUniversity.getName());
			}
			else {
				System.out.println("null");
			}
			
		}
	}

}





