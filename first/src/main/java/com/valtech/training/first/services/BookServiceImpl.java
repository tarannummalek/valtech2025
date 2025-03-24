package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.first.entities.Book;

import com.valtech.training.first.repos.BookRepo;
import com.valtech.training.first.dtos.BookInfoDTO;
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepo bookRepo;
	
	@Override
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}

	@Override
	public List<Book> getBooksByYearBetween(int i, int j) {
		// TODO Auto-generated method stub
		return bookRepo.findAllByYearBetween(i, j);
	}

	@Override
	public List<Book> getBooksByPriceGreaterThan(int i) {
		// TODO Auto-generated method stub
		return bookRepo.findAllByPriceGreaterThan(i);
	}

	@Override
	public List<Book> getBooksByAuthorsId(int i) {
		// TODO Auto-generated method stub
		return bookRepo.findAllByAuthorsId(i);
	}

	@Override
	public List<Integer> getPricesByAuthorsId(int i) {
		// TODO Auto-generated method stub
		return bookRepo.findAllPriceByAuthorsId(i);
	}
	
	public List<BookInfoDTO> getBookInfoByAuthor(long id){
		return bookRepo.getBookInfoByAuthor(id);
	}
}
