package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Employee;

public class DeleteEmployee {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("Lesson33_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Employee employee = entitymanager.find(Employee.class, 3);
		entitymanager.remove(employee);
		
		entitymanager.getTransaction().commit();
		
		entitymanager.close();
		emfactory.close();
		
		
		System.out.println("deleted ");
		
	}
}
