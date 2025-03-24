package com.valtech.training.restapi.services;

import java.util.List;

import com.valtech.training.restapi.vos.OwnerVO;

public interface OwnerService {

	OwnerVO getOwnerById(long id);

	OwnerVO createOwner(OwnerVO ownerVO);

	OwnerVO updateOwner(long id, OwnerVO ownerVO);

	List<OwnerVO> getAllOwners();

	OwnerVO addWatchesToOwner(long id, List<Long> watches);

}