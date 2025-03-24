package com.valtech.training.first.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valtech.training.first.entities.Author;
@Service
public interface AuthorService {

	List<Author> getAll();

}