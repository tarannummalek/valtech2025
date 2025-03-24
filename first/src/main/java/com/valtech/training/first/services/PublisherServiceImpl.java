package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.first.entities.Publisher;
import com.valtech.training.first.repos.Publisherrepo;
@Service
public class PublisherServiceImpl implements PublisherService {
	
	@Autowired
	Publisherrepo publicrepo;
	
	@Override
	public List<Publisher> getAllpublishers(){;
	return publicrepo.findAll();
	}

}
