package model;

public class Question {
	
	private int qId;
	private String question;
	private String o1;
	private String o2;
	private String o3;
	private String o4;
	private String answer;
	private int quiz_id;
	
	
	
	public Question() {
	}
	
	
	public Question(int qId,String question, String o1, String o2, String o3, String o4, String answer,int quiz_id) {
		super();
		this.qId=qId;
		this.question = question;
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
		this.o4 = o4;
		this.answer = answer;
		this.quiz_id=quiz_id;
	}


	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getO1() {
		return o1;
	}
	public void setO1(String o1) {
		this.o1 = o1;
	}
	public String getO2() {
		return o2;
	}
	public void setO2(String o2) {
		this.o2 = o2;
	}
	public String getO3() {
		return o3;
	}
	public void setO3(String o3) {
		this.o3 = o3;
	}
	public String getO4() {
		return o4;
	}
	public void setO4(String o4) {
		this.o4 = o4;
	}
	public String getAnswer() {
		return answer;
	}


	public int getqId() {
		return qId;
	}


	public void setqId(int qId) {
		this.qId = qId;
	}


	public int getQuiz_id() {
		return quiz_id;
	}


	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
}
