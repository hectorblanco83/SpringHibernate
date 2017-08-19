package hb.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entity mapping the "movies" table in the database.
 * <p>
 * {@link Entity} and {@link Table} indicates to spring's component scan that
 * this class is a database entity that maps the indicated table,
 * and {@link Id} specifies this entity's primary key
 */
@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	private String id;
	private String name;
	
	
	public Movie() {
	}
	
	
	public Movie(String name) {
		this.name = name;
	}
	
	
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
}
