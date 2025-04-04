package com.valtech.training.questionservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.questionservice.entities.Question;
@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{
	
	List<Question> findAllByTopic(String topic);

}
