package com.valtech.training.streamingservice.entities;

import jakarta.persistence.Entity;

@Entity
public class Movie extends Content{
	
	
	private long duration;

	
	public Movie() {
		
	}

	public Movie(String name, String language, String genre, long duration,long costPerView) {
		super(name, language, genre,costPerView);
		this.duration = duration;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	
	
	

	
}
