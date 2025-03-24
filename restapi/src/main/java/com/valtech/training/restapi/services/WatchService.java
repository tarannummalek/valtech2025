package com.valtech.training.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.restapi.entities.Watch;
import com.valtech.training.restapi.repos.WatchRepo;
import com.valtech.training.restapi.vos.WatchVO;


public interface WatchService {

	

	

	List<WatchVO> getWatches();

	WatchVO getWatch(long id);

	WatchVO updateWatch(long id, WatchVO watch);

	WatchVO createWatch(WatchVO watchVO);

	List<WatchVO> getWatchesByBrand(String brand);



}