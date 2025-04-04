package services;

import java.io.IOException;

import dao.StudentDAO;
import daoImpl.StudentDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/students")
public class StudentServlet extends HttpServlet {
	
	private StudentDAO studentDAO;
	@Override
		public void init(ServletConfig config) throws ServletException {

		studentDAO=new StudentDAOImpl(config.getServletContext());
		
		}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
req.setAttribute("students", studentDAO.getAllStudents());
req.getRequestDispatcher("students.jsp").forward(req, resp);
}
}
