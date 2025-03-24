package com.valtech.training.registerservice.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;
import com.valtech.training.registerservice.vos.UserVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	@Override
	public UserVO addUserToSubscription(UserVO userVO,long id) {
		Subscription subscription=subscriptionRepo.getReferenceById(id);
		subscriptionRepo.save(subscription);
		return UserVO.from( userRepo.save(userVO.to(subscriptionRepo.getReferenceById(userVO.subId()))));
	}
	
	@Override
	public UserVO getUser(long id) {
		return UserVO.from(userRepo.getReferenceById(id));
	}
	
	@Override
	public List<UserVO> getUsersBySubscriptionId(long subId) {
		return userRepo.findAllBySubscriptionId(subId).stream().map(s->UserVO.from(s)).collect(Collectors.toList());
		
	}
	
	@Override
	public UserVO signUp(UserVO userVO) {
		Subscription subscription=new Subscription(0, null, null);
		subscription.setSubscriptionStart(LocalDate.now());
		subscription.setSubscriptionEnd(LocalDate.now().plusYears(1));
		
		subscription.setAmount(2000);
		subscription.addUser(userVO.to(subscription));
		subscriptionRepo.save(subscription);
	return	UserVO.from(userRepo.save(userVO.to(subscription)));
			
		
	}

	@Override
	public List<UserVO> getAll() {
		
		return userRepo.findAll().stream().map(u->UserVO.from(u)).collect(Collectors.toList());
				
	}

	@Override
	public void removeUser(long id) {
		User user=userRepo.getReferenceById(id);
		Subscription s= user.getSubscription();
		s.remove(user);
		//subscriptionRepo.save(s);
		userRepo.deleteById(id);
		//userRepo.delete(userRepo.getReferenceById(id));
		
	}
	

}
