package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.vos.UserVO;

public interface UserService {

	UserVO addUserToSubscription(UserVO userVO,long id);

	UserVO getUser(long id);

	List<UserVO> getUsersBySubscriptionId(long subId);

	UserVO signUp(UserVO userVO);

	List<UserVO> getAll();

	void removeUser(long id);

}