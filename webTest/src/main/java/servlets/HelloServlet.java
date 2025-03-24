package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String company=config.getInitParameter("company");
	System.out.println("init...!!!"+company);
	
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Service...");
		String name=request.getParameter("name");
		System.out.println("name: "+name);
		PrintWriter out=response.getWriter();
		out.print("HEllo Servlets!!"+name);
	
	}
	
	@Override
	public void destroy() {
		
		System.out.println("Destrpyed....!!!");
	}
	

}
