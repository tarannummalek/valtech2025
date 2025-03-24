package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.SubscriptionVO;

public interface SubscriptionService {

	SubscriptionVO getById(long id);

	//SubscriptionVO addSubscription(SubscriptionVO subscriptionVO);

	List<SubscriptionVO> getAllSubscriptions();

}