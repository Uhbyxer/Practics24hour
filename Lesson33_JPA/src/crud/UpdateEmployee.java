package crud;

import javax.persistence.*;

import model.Employee;

public class UpdateEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("Lesson33_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Employee employee = entitymanager.find(Employee.class, 1);
		
		System.out.println("before: ");
		System.out.println(employee);
		employee.setJobTitle("Senior Java");
		entitymanager.getTransaction().commit();
		
		entitymanager.close();
		emfactory.close();
		
		
		
		
	}

}
