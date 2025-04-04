package dao;

import java.util.List;

import model.Question;
import model.Quiz;

public interface QuizDAO {
	 Quiz getQuiz(int id) ;
	 List<Question> getQuestionsByQuizId(int id);
	 int addQuiz(Quiz quiz);
	 int deleteQuiz(int id);
	 int updateQuiz(Quiz q);
	 int getResultOfQuizByid(int id);
	 

}
