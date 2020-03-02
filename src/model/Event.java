package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

@Entity
@Table(name = "events")
public class Event 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EVENT_LIST")
	private int id;
	@Column(name="EVENT_NAME")
	private String name;
	@Column(name="EVENT_TIME")
	private DateTime time;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="EMPLOYEE_ID")
	private Person host;
	
	Event() 
	{
		super();
	}
	
	Event(String name, DateTime time, Person host) 
	{
		super();
		this.name = name;
		this.time = time;
		this.host = host;
	}
	
	public String returnEventDetails() 
	{
		return name + " | " + time + " | "; //+ host.getName();
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

	public DateTime getTime()
	{
		return time;
	}

	public void setTime(DateTime time)
	{
		this.time = time;
	}

	public Person getHost()
	{
		return host;
	}

	public void setHost(Person host)
	{
		this.host = host;
	}
	
}
