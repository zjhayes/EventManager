package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import model.Event;


public class EventHelper
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EventManager");
	
	public void insertEvent(Event toInsert) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toInsert);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Event> showAllEvents()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Event> allPeople = em.createQuery("SELECT p FROM Event p").getResultList();
		return allPeople;
	}
	
	public Event searchForEventById(int id) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Event found = em.find(Event.class, id);
		em.close();
		return found;	
	}
	
	public void deleteEvent(Event ToDelete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Event> typedQuery = em.createQuery("SELECT p FROM Event p WHERE p.event_list = :selectedId", Event.class);
		typedQuery.setParameter("selectedId", ToDelete.getId());	
		typedQuery.setMaxResults(1);
		
		Event result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateEvent(Event toEdit)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction();
		em.close();
	}
	
	// TODO Will need to convert DateTime to Date
	public List<Event> searchForEventByDate(DateTime date)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Event> typedQuery = em.createQuery("SELECT e FROM Event e WHERE e.event_date = :selectedDate", Event.class);
		typedQuery.setParameter("selectedDate", date);
		
		List<Event> foundEvents = typedQuery.getResultList();
		em.close();
		return foundEvents;
	}
	
	public void cleanUp() 
	{
		emfactory.close();
	}
}

