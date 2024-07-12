package customer;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.customer;

public class customers {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	customer cus = new customer();
//	
	System.out.println("Enter Name");
	cus.setName(sc.next());
	System.out.println("Enter email");
	cus.setEmail(sc.next());
	System.out.println("Enter Password");
	cus.setPassword(sc.next());
	System.out.println("enter number");
	cus.setNumber(sc.next());
	
	//<----------------------------------------------------------------------------------------------------------------------->
	
	                                        /*Saving the transaction permanently*/
	 
	//Establishing connection between java file and data base 'createEntityManagerFactory' -> static method
	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("SecondJpa");
	System.out.println("Connection Establlished");
	
	EntityManager entityManager = managerFactory.createEntityManager();
	System.out.println("Platform Created");
	
	EntityTransaction transaction  = entityManager.getTransaction();
	transaction.begin();
	System.out.println("Transaction begin");
	
	entityManager.persist(cus);
	
	transaction.commit();
	System.out.println("transaction commited");
	
	entityManager.close();
	System.out.println("Closing the Platform");
	
	managerFactory.close();
	System.out.println("Closing the connection");
	//<----------------------------------------------------------------------------------------------------------------------------->

}
}
