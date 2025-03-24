package com.valtech.training.restapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.restapi.entities.Owner;
import com.valtech.training.restapi.repos.OwnerRepo;
import com.valtech.training.restapi.repos.WatchRepo;
import com.valtech.training.restapi.vos.OwnerVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OwnerServiceImpl implements OwnerService {
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	WatchRepo watchRepo;
	
	@Override
	public OwnerVO getOwnerById(long id) {
		return OwnerVO.from(ownerRepo.getReferenceById(id));
	}
	@Override
	public OwnerVO createOwner(OwnerVO ownerVO) {
		Owner o=ownerVO.toOwner(ownerVO);
		return OwnerVO.from(ownerRepo.save(o));
	}
	@Override
	public OwnerVO updateOwner(long id,OwnerVO ownerVO) {
		Owner o=ownerRepo.getReferenceById(id);
		ownerVO.updateOwnerFromVO(o);
		return OwnerVO.from(ownerRepo.save(o));
	}
	
	@Override
	public List<OwnerVO> getAllOwners(){
		return ownerRepo.findAll().stream().map(o->OwnerVO.from(o)).collect(Collectors.toList());
	}
	@Override
	public OwnerVO addWatchesToOwner(long id, List<Long> watches) {
		final Owner owner=ownerRepo.getReferenceById(id);
		watches.stream().forEach(o->owner.addWatch(watchRepo.getReferenceById(o)));
		Owner owner1=ownerRepo.save(owner);
		
		return OwnerVO.from(owner1);
	}

}
