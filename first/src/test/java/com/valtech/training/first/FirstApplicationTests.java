package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.AuthorService;
import com.valtech.training.first.services.BookService;
import com.valtech.training.first.services.PublisherService;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
class FirstApplicationTests {

	@Autowired
	private Arithmatic arithmatic;
	
	@Autowired
	private SimpleInterast simpleInterast;
	
	@Test
	void testArithmatic() {
		assertEquals(10, arithmatic.add(4, 6));
		
	}
	@Test
	void testSimpleInterest() {
		assertEquals(4, simpleInterast.compute(1, 20, 20));
		
	}
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	@Rollback()
	void testQuestionService() {
		initData();
		assertEquals(6, questionService.countByTopic("GK"));
		assertEquals(7, questionService.countByTopic("java"));
		assertEquals(2, questionService.countByTopicAndQuestionTextContaining("java","exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContainingIgnoreCase("java","Interface"));
		assertEquals(5, questionService.getAllQuestionsBytopic("GK", 0, 5).size());
		assertEquals(1, questionService.getAllQuestionsBytopic("GK", 1, 5).size());
//		System.out.println("Question class name "+questionService.getClass().getName()  );
//		long  count=questionService.count();
//		
//		
//
//		assertTrue(q.getId()>0);
//		assertEquals(count+1, questionService.count());
	}

	void initData() {
		
		Question q=  questionService.saveQuestion(new Question("what is color of sky","white","blue","pink","black","black","GK"));
		questionService.saveQuestion(new Question("what is color of mars","white","red","pink","black","red","GK"));
		questionService.saveQuestion(new Question("what is color of jupitor","white","yellow","pink","black","yellow","GK"));
		questionService.saveQuestion(new Question("what is color of sun","white","yellow","pink","black","yellow","GK"));
		questionService.saveQuestion(new Question("what is color of venus","white","blue","pink","black","white","GK"));
		questionService.saveQuestion(new Question("what is color of saturn","white","blue","pink","black","blue","GK"));
		
		questionService.saveQuestion(new Question("what is super class of exception", "object", "exception", "Throwable", "error", "Throwable", "java"));
		questionService.saveQuestion(new Question("which class is used to make thraed",  "Thread", "exception", "throwable", "error", "Thread", "java"));
		questionService.saveQuestion(new Question("whow many methods in marker interface",  "one", "two", "three", "zero", "zero", "java"));
		questionService.saveQuestion(new Question("what is String in java",  "class", "interface", "method", "argument", "class", "java"));
		questionService.saveQuestion(new Question("can an interface have private methods",  "yes", "no", "maybe", "No methods in interface", "zero", "java"));
		questionService.saveQuestion(new Question("how many methods in functional interface",  "one", "two", "three", "zero", "one", "java"));
		questionService.saveQuestion(new Question("which subclas of exception is not checked by compiler",  "exception", "error", "runtime exception", "throwable","runtime exception", "java"));


	}
	
	@Autowired
	AuthorService authorServiceImpl;
	
	@Autowired
	PublisherService impl;
	
	@Autowired
	BookService bookService;
	
	@Test
	void testPublishers() {
		assertEquals(6, impl.getAllpublishers().size());
	}
	
	@Test
	void testAuthors() {
		assertEquals(12, authorServiceImpl.getAll().size());
	
	}
	
	@Test
	void testBooks() {
	assertEquals(12, bookService.getAllBooks().size());
	assertEquals(8, bookService.getBooksByYearBetween(2000,2006).size());
	assertEquals(6, bookService.getBooksByPriceGreaterThan(100).size());
	assertEquals(2, bookService.getBooksByAuthorsId(2).size());
	assertEquals(2, bookService.getPricesByAuthorsId(2).size());
	System.err.println( bookService.getBookInfoByAuthor(2));
	System.out.println(bookService.getPricesByAuthorsId(2));
	}
	

	
}
