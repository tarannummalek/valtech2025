package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.first.entities.Author;
import com.valtech.training.first.repos.AuthorRepo;
@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorRepo authorRepo;
	
	
	@Override
	public List<Author> getAll(){
		return authorRepo.findAll();
	}
		
	

}


