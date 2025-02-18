package model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Quiz {

	List<Question> questions;
	Teacher owner;
	int id;
	//List<Student> studentsAttended;
	int result;
	String name;
	
	
	public Quiz() {
	}
	
	
	
	public Quiz(List<Question> questions,int id, String name, int result) {
		this.questions = questions;
		this.id = id;
		this.result = result;
		this.name = name;
	}



//	public Quiz(List<Question> questions, Teacher owner) {
//		this.questions = questions;
//		this.owner = owner;
//	
//	}
	


	public List<Question> getQuestions() {
		return questions;
	}
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getResult() {
		return result;
	}



	public void setResult(int result) {
		this.result = result;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public Teacher getOwner() {
		return owner;
	}
	public void setOwner(Teacher owner) {
		this.owner = owner;
	}
//	public List<Student> getStudentsAttended() {
//		return studentsAttended;
//	}
//	public void setStudentsAttended(List<Student> studentsAttended) {
//		this.studentsAttended = studentsAttended;
//		
//	}


	@Override
	public int hashCode() {
		return Objects.hash(owner, questions);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz other = (Quiz) obj;
		return Objects.equals(owner, other.owner) && Objects.equals(questions, other.questions)
				;
	}


	@Override
	public String toString() {
		return "Quiz [questions=" + questions + ", owner=" + owner + "]";
	}
	
	
}
