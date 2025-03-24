package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.streamingservice.repos.WebSeriesRepo;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@Service
public class WebSeriesServiceImpl implements WebSeriesService {
	
	@Autowired
	private WebSeriesRepo webSeriesRepo;
	
	@Override
	public WebSeriesVO getWebSeries(long id) {
		return WebSeriesVO.from(webSeriesRepo.getReferenceById(id));
	}
	
	@Override
	public WebSeriesVO create(WebSeriesVO vo) {
		return WebSeriesVO.from(webSeriesRepo.save(vo.to()));
	}
	
	@Override
	public List<WebSeriesVO> getAllwebSeries(){
		return WebSeriesVO.from(webSeriesRepo.findAll());
	}
	
	@Override
	public List<WebSeriesVO> getAllByEpiosodeCount(int epCount){
		return WebSeriesVO.from(webSeriesRepo.findAllByEpisodeCount(epCount));
	}
	@Override
	public List<WebSeriesVO> getAllByEpiosodeDuration(long epDuration){
		return WebSeriesVO.from(webSeriesRepo.findAllByEpisodeDuration(epDuration));
	}

}
