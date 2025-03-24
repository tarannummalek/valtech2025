package com.valtech.training.first.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.first.entities.Publisher;

public interface Publisherrepo extends JpaRepository<Publisher, Integer> {
	
	List<Publisher> findAll();

}
