package com.valtech.training.streamingservice.entities;

import jakarta.persistence.Entity;

@Entity
public class WebSeries extends Content {
	
	private int episodeCount;
	private long episodeDuration;
	public WebSeries() {
		super();
	}
	public WebSeries(String name, String language, String genre, long costPerView) {
		super(name, language, genre, costPerView);
	}
	
	public WebSeries(String name, String language, String genre, long costPerView, int episodeCount,
			long episodeDuration) {
		super(name, language, genre, costPerView);
		this.episodeCount = episodeCount;
		this.episodeDuration = episodeDuration;
	}
	public int getEpisodeCount() {
		return episodeCount;
	}
	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}
	public long getEpisodeDuration() {
		return episodeDuration;
	}
	public void setEpisodeDuration(long episodeDuration) {
		this.episodeDuration = episodeDuration;
	}
	
	

}
