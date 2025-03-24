package com.valtech.training.streamingservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.streamingservice.entities.WebSeries;

public record WebSeriesVO(long id, String name,String language, String genre,long costPerView,int episodeCount,long episodeDuration) {

	
	public static WebSeriesVO from(WebSeries series) {
		return new WebSeriesVO(series.getId(), series.getName(), series.getLanguage(), series.getGenre(), series.getCostPerView(), series.getEpisodeCount(), series.getEpisodeDuration());
	}
	
	public WebSeries to() {
		return new WebSeries(name, language, genre, costPerView, episodeCount, episodeDuration);
	}
	
	public static List<WebSeriesVO> from(List<WebSeries> list){
		return list.stream().map(w->WebSeriesVO.from(w)).collect(Collectors.toList());
	}
	public List<WebSeries> to(List<WebSeriesVO> list){
		return list.stream().map(w->w.to()).collect(Collectors.toList());
	}
}
