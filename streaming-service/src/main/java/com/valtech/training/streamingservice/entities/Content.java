package com.valtech.training.streamingservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
@MappedSuperclass
public class Content {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "content_seq")
	@SequenceGenerator(name = "content_seq",sequenceName = "content_seq",allocationSize = 1)
	private long id;
	
	private String name;
	
	private String language;
	
	private String genre;
	
	private long costPerView;

	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Content(String name, String language, String genre,long costPerView) {

		this.language = language;
		this.genre = genre;
		this.name=name;
		this.costPerView=costPerView;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCostPerView() {
		return costPerView;
	}

	public void setCostPerView(long costPerView) {
		this.costPerView = costPerView;
	}
	
	
	

}
