package services;

import java.io.IOException;
import java.util.List;

import daoImpl.QuizDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Question;
import model.Quiz;
@WebServlet("/quiz")
public class quizServlet extends HttpServlet {
	
	QuizDAOImpl daoImpl;
	@Override
	public void init() throws ServletException {
		daoImpl=new QuizDAOImpl();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation= req.getParameter("operation");
		

		if("add".equals(operation)) {
			req.getRequestDispatcher("addQuiz.jsp").forward(req, resp);
			
			return;	
		}
		
		
		
		Quiz quiz=daoImpl.getQuiz(1);
		req.setAttribute("questions", quiz.getQuestions());
		req.setAttribute("q_name", quiz.getName());
//		req.setAttribute("q_name", quiz.);
		req.setAttribute("maxMarks", quiz.getResult());
		
		req.getRequestDispatcher("quiz.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ans;	
		String submitted1=req.getParameter("ans1");
		String submitted2=req.getParameter("ans2");
		String submitted3=req.getParameter("ans3");
		String submitted4=req.getParameter("ans4");
		
		
		
		
		List<Question> questions=daoImpl.getQuestionsByQuizId(1);
		
		int result=0;
		for(Question q:questions) {
			if(q.getAnswer()==submitted1) {
				result++;
			}
		}
		req.setAttribute("result", result);
		System.out.println("answer");
		
		
		req.getRequestDispatcher("quiz.jsp").forward(req, resp);
		//req.getParameter("");
		
		
		
		
		
	}
}
