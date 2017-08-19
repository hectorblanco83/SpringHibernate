package hb.controllers;

import hb.models.Movie;
import hb.models.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Only controller that we need, listening to requests on the context-path's root "/"
 */
@Controller
public class MovieController {
	
	@Autowired
	private MovieDAO movieDAO;
	
	
	/**
	 * Find all movies.
	 *
	 * {@link RequestMapping} indicates that this method responds on "/all".
	 * {@link ResponseBody} indicates a method return value should be bound
	 * to the web response body
	 */
	@ResponseBody
	@RequestMapping("all")
	public List<Movie> findAll() {
		return movieDAO.findAll();
	}
	
}
