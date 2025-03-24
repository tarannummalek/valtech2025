package com.valtech.training.questionservice.vos;

import com.valtech.training.questionservice.entities.Question;

public record QuestionVO (long id,String queText,String option1,String option2,String option3,String option4,String correctOption,String topic){
	
	public static QuestionVO from(Question question) {
		return new QuestionVO(question.getId(), question.getQuestionText(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4(), question.getCorrectOption(),question.getTopic());
	}
	
	public Question to() {
		Question question=new Question(queText, option1, option2, option3, option4, correctOption,topic);
		question.setId(id);
		return question;
	}

}
