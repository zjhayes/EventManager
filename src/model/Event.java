package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "events")
public class Event implements Comparable<Event>
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EVENT_LIST")
	private int id;
	@Column(name="EVENT_NAME")
	private String name;
	@Column(name="EVENT_DATE")
	private LocalDate EventDate;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="EMPLOYEE_ID")
	private Person host;
	
	public Event() 
	{
		super();
	}
	
	public Event(String name, LocalDate EventDate, Person host) 
	{
		super();
		this.name = name;
		this.EventDate = EventDate;
		this.host = host;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public LocalDate getEventDate()
	{
		return EventDate;
	}

	public void setEventDate(LocalDate EventDate)
	{
		this.EventDate = EventDate;
	}

	public Person getHost()
	{
		return host;
	}

	public void setHost(Person host)
	{
		this.host = host;
	}
	
	public String returnEventDetails() 
	{
		return name + " | " + EventDate + " | " + host.getFirstName() + " " + host.getLastName();
	}
	
	@Override
	public int compareTo(Event compareEvent)
	{
		return this.getEventDate().compareTo(compareEvent.getEventDate());
	}
}
