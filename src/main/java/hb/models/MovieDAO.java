package hb.models;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


/**
 * Data Access for the Movie entity.
 * <p>
 * {@link Repository} annotation allows the component scanning support
 * to find and configure the DAO wihtout any XML configuration and also
 * provide the Spring exception translation.
 * <p>
 * Since we've setup setPackagesToScan and transaction manager on DatabaseConfig,
 * any bean method annotated with Transactional will cause Spring to call begin() and
 * commit() at the start/end of the method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class MovieDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * Save the movie in the database.
	 */
	public void create(Movie movie) {
		entityManager.persist(movie);
	}
	
	
	/**
	 * Delete the movie from the database.
	 */
	public void delete(Movie movie) {
		if (entityManager.contains(movie)) {
			entityManager.remove(movie);
		} else {
			entityManager.remove(entityManager.merge(movie));
		}
	}
	
	
	/**
	 * Update the passed movie in the database.
	 */
	public void update(Movie movie) {
		entityManager.merge(movie);
	}
	
	
	/**
	 * Return all the movies stored in the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Movie> findAll() {
		// create query with hql, hibernate's query language, where Movie is an entity that maps a table
		return entityManager.createQuery("FROM Movie").getResultList();
	}
	
	
	/**
	 * Return the movie having the passed id.
	 */
	public Movie findById(long id) {
		// find tankes in input a class annotated with @Entity and it's primary key
		return entityManager.find(Movie.class, id);
	}
	
	
	/**
	 * Return the movie having the passed name.
	 */
	public Movie findByName(String name) {
		// create query with hql, hibernate's query language, where Movie is an entity that maps a table
		return (Movie) entityManager.createQuery("FROM Movie WHERE name = :name").setParameter("name", name).getSingleResult();
	}
	
}