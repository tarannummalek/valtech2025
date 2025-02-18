package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class DatabaseConfigurationListner implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext= sce.getServletContext();
		try(InputStream input=servletContext.getResourceAsStream("WEB-INF/config.properties")){
		
			Properties properties=new Properties();
			if(input!=null) {
			properties.load(input);}
			servletContext.setAttribute("url", properties.getProperty("jdbc.url"));
			servletContext.setAttribute("username", properties.getProperty("jdbc.username"));
			servletContext.setAttribute("password", properties.getProperty("jdbc.password"));
			String driver=properties.getProperty("jdbc.driver");

			Class.forName(driver);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
