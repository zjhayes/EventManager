package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Person;

public class PersonHelper
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EventManager");
	
	public void insertPerson(Person toInsert) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toInsert);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Person> showAllPeople()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Person> allPeople = em.createQuery("SELECT p FROM Person p").getResultList();
		return allPeople;
	}
	
	public Person searchForPersonById(int id) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Person found = em.find(Person.class, id);
		em.close();
		return found;	
	}
	
	public void deletePerson(Person ToDelete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Person> typedQuery = em.createQuery("SELECT p FROM Person p WHERE p.employee_id = :selectedId", Person.class);
		typedQuery.setParameter("selectedId", ToDelete.getId());	
		typedQuery.setMaxResults(1);
		
		Person result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updatePerson(Person toEdit)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction();
		em.close();
	}
	
	
	public List<Person> searchForPersonByName(String firstName, String lastName)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Person> typedQuery = em.createQuery("SELECT p FROM Person p WHERE p.first_name = :selectedFirstName and p.last_name = :selectedLastName", Person.class);
		typedQuery.setParameter("selectedFirstName", firstName);
		typedQuery.setParameter("selectedLastName", lastName);
		
		List<Person> foundPeople = typedQuery.getResultList();
		em.close();
		return foundPeople;
	}
	
	public void cleanUp() 
	{
		emfactory.close();
	}
}







