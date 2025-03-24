package com.valtech.training.restapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.restapi.entities.Watch;
import com.valtech.training.restapi.repos.WatchRepo;
import com.valtech.training.restapi.vos.WatchVO;


@Service
@Transactional(propagation =Propagation.REQUIRED)
public class WatchServcieImpl implements WatchService {
	
	@Autowired
	WatchRepo watchrepo;
	
	@Override
	public WatchVO createWatch(WatchVO watchVO) {
		return WatchVO.from(watchrepo.save(watchVO.toWatch()));
	}
	
	
	@Override
	public WatchVO updateWatch(long id,WatchVO watch) {
		Watch watch1=watchrepo.getReferenceById(id);
		watch.updateWatchFromVO(watch1);
		return WatchVO.from(watchrepo.save(watch1));
	}
	
	
	@Override
	public WatchVO getWatch(long id) {
		return WatchVO.from(watchrepo.getReferenceById(id));
	}
	
	
	@Override
	public List<WatchVO> getWatches(){
		return WatchVO.toWatchVOList(watchrepo.findAll());
		}


	@Override
	public List<WatchVO> getWatchesByBrand(String brand) {
		return WatchVO.toWatchVOList(watchrepo.findAllByBrand(brand));
		
	}
	
	

}
