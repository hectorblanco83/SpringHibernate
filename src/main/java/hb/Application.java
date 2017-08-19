package hb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 * Main and configuration class for the application.
 *
 * The {@link SpringBootApplication} is a convenience annotation that adds all of the following:
 * <ul>
 *     <li>
 *         {@link Configuration} tags the class as a source of bean definitions for the application context.
 *     </li>
 *     <li>
 *         {@link EnableAutoConfiguration} tells Spring Boot to start adding beans based on classpath settings,
 *         other beans, and various property settings.
 *     </li>
 *     <li>
 *         {@link ComponentScan} tells Spring to look for other components, configurations, and services in the
 *         main package, allowing it to find the controllers.
 *     </li>
 * </ul>
 * Normally you would add {@link EnableWebMvc} for a Spring MVC app, but Spring Boot adds it automatically
 * when it sees spring-webmvc on the classpath. This flags the application as a web application and
 * activates key behaviors such as setting up a DispatcherServlet.
 */
@SpringBootApplication
public class Application {
	
	
	/**
	 * Application's entry point.
	 * <p>
	 * {@link SpringApplication#run(String...)} runs the Spring application, creating and refreshing a new {@link ApplicationContext}.
	 * Web server properties, like context-path and port are defined in the file application.properties
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
}
