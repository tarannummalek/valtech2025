package com.valtech.training.resultservice.vos;

import java.util.List;

public class AttemtedQuizVO {

    private List<QuestionResultVO> questionResultVOs;

    public AttemtedQuizVO() {
        super();
    }

    public AttemtedQuizVO(List<QuestionResultVO> questionResultVOs) {
        super();
        this.questionResultVOs = questionResultVOs;
    }

    public List<QuestionResultVO> getQuestionResultVOs() {
        return questionResultVOs;
    }

    public void setQuestionResultVOs(List<QuestionResultVO> questionResultVOs) {
        this.questionResultVOs = questionResultVOs;
    }
}
