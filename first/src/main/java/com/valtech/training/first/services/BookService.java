package com.valtech.training.first.services;

import java.util.List;
import com.valtech.training.first.dtos.BookInfoDTO;
import org.springframework.stereotype.Service;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Question;
@Service
public interface BookService {
	
	List<Book> getAllBooks()
;

	List<Book> getBooksByYearBetween(int i, int j);

	List<Book> getBooksByPriceGreaterThan(int i);

	List<Book> getBooksByAuthorsId(int i);

	List<Integer> getPricesByAuthorsId(int i);
	
	List<BookInfoDTO> getBookInfoByAuthor(long id);
	
}