package com.valtech.training.registerservice.vos;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record UserVO (long id,String name,int age,String email,boolean isKid,Long subId){

	public static UserVO from(User u) {
		return new UserVO(u.getId(), u.getName(), u.getAge(), u.getEmail(), u.isKid(),u.getSubscription().getId());
	}
	
	public User to(Subscription subscription) {
		User user= new User(age, name, age, email, isKid);
		user.setSubscription(subscription);
		return user;
	}
}
