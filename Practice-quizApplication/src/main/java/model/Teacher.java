package model;

import java.util.Set;

public class Teacher {

	private String iId;
	private Set<Quiz> quizesCreated;
	public Teacher() {
	}
	public Teacher(String iId, Set<Quiz> quizesCreated) {
		super();
		this.iId = iId;
		this.quizesCreated = quizesCreated;
	}
	public String getiId() {
		return iId;
	}
	public void setiId(String iId) {
		this.iId = iId;
	}
	public Set<Quiz> getQuizesCreated() {
		return quizesCreated;
	}
	public void setQuizesCreated(Set<Quiz> quizesCreated) {
		this.quizesCreated = quizesCreated;
	}
	@Override
	public String toString() {
		return "Teacher [iId=" + iId + ", quizesCreated=" + quizesCreated + "]";
	}
	
	
	
	
}
