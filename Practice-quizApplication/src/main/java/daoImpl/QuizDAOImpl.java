package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.QuizDAO;
import jakarta.servlet.ServletContext;
import model.Question;
import model.Quiz;
import model.Student;

public class QuizDAOImpl implements QuizDAO {
	
	static {
		try {
		Class.forName("org.postgresql.Driver");}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}
		
	}
	
	ServletContext sc;

	private Connection getConnection(ServletContext sc) throws SQLException {
		
//		String username =(String) sc.getAttribute("username");
//		String password=(String) sc.getAttribute("password");
//		String url=(String) sc.getAttribute("url");
		
		
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
		
	}
	
	@Override
	public Quiz getQuiz(int id) {
		try(Connection conn=getConnection(this.sc) ){
			PreparedStatement ps=conn.prepareStatement("SELECT ID,QUE,O1,O2,O3,O4 , ANSWER FROM QUESTION WHERE QUIZ_ID= ?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			List<Question> quetionsList=new ArrayList<Question>();
			while(rs.next()) {
				quetionsList.add(new Question(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),id));
				
			}
//			 
			PreparedStatement ps1=conn.prepareStatement("SELECT ID,NAME,RESULT FROM QUIZ WHERE ID= ?");
			ps1.setInt(1, id);
			ResultSet rs1=ps1.executeQuery();
			Quiz q;
			if(rs1.next()) {
				 q=new Quiz(quetionsList,rs1.getInt(1),rs1.getString(2),rs1.getInt(3));
				 return q;
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Question> getQuestionsByQuizId(int id) {
		try(Connection conn=getConnection(this.sc) ){
			PreparedStatement ps=conn.prepareStatement("SELECT ID,QUE,O1,O2,O3,O4 , ANSWER FROM QUESTION WHERE QUIZ_ID= ?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			List<Question> quetionsList=new ArrayList<Question>();
			while(rs.next()) {
				quetionsList.add(new Question(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),id));
				
			}
			 return quetionsList;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public List<Question> getQuestionsByQuizId(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteQuiz(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateQuiz(Quiz q) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResultOfQuizByid(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
//	private Student populateQuiz(ResultSet rs) throws SQLException {
//		Quiz quiz=new Quiz(rs.getInt(1),rs.getString(2),rs.getDate(3));
//		return s;
//	}
	

}
