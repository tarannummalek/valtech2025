package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.WebSeriesVO;

public interface WebSeriesService {

	WebSeriesVO getWebSeries(long id);

	WebSeriesVO create(WebSeriesVO vo);

	List<WebSeriesVO> getAllwebSeries();

	List<WebSeriesVO> getAllByEpiosodeCount(int epCount);

	List<WebSeriesVO> getAllByEpiosodeDuration(long epDuration);

}