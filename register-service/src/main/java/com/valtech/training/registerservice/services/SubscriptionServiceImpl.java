package com.valtech.training.registerservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;
import com.valtech.training.registerservice.vos.UserVO;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepo subscriptionRepo;
	@Autowired
	private UserService userService;
	
	@Override
	public SubscriptionVO getById(long id) {
		return SubscriptionVO.from(subscriptionRepo.getReferenceById(id));
	}
	
//	@Override
//	public SubscriptionVO addSubscription(SubscriptionVO subscriptionVO) {
//		List<UserVO> users=userService.getUsersBySubscriptionId(subscriptionVO.id());
//		//List<User> userList=users.stream().map(u->u.to()).collect(Collectors.toList());
//		return SubscriptionVO.from(subscriptionRepo.save(subscriptionVO.to(users)));
//	}

	@Override
	public List<SubscriptionVO> getAllSubscriptions() {
		return subscriptionRepo.findAll().stream().map(s->SubscriptionVO.from(s)).collect(Collectors.toList());
	}

}
