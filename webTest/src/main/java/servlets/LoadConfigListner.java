package servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListner implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

	System.out.println("First code that is executed");
	System.out.println("loading ... config... done...");
	System.out.println("creating DB pools");
	System.out.println();
	
	
	// this context can be shared though out the app
	ServletContext application=sce.getServletContext();
	
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("CLOSING ALL DBS IN CONNECTION POOLS...");
	
	
	
	}
	
	
	
	
	
}
