package crud;

import javax.persistence.*;

import model.Employee;

public class CreateEmployee {

	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Lesson33_JPA");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Employee employee = new Employee();
		employee.setEname("Ira");
		employee.setJobTitle("Secretary");
		
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		emfactory.close();
		
		
		System.out.println("CreateEmployee done");
	}

}
