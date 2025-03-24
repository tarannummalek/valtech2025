package com.valtech.training.registerservice.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;


public record SubscriptionVO (long id,int amount, String subscriptionStart,String subscriptionEnd,List<Long> userIds){

	public static final DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern("dd-MM-yy");

public static SubscriptionVO from(Subscription subscription) {
	String startDate=subscription.getSubscriptionStart().format(FORMATTER);
	String endDate=subscription.getSubscriptionEnd().format(FORMATTER);
	List<Long> listOfIds=subscription.getUsers().stream().map(s->s.getId()).collect(Collectors.toList());
	return new SubscriptionVO(subscription.getId(), subscription.getAmount(), startDate, endDate,listOfIds);
}

public Subscription to(List<User> users) {
	LocalDate start=LocalDate.parse(subscriptionStart, FORMATTER);
	LocalDate end=LocalDate.parse(subscriptionEnd, FORMATTER);
	Subscription subscription=new  Subscription( amount, start, end);
	//subscription.setId(id);
	subscription.setUsers(users);
	return subscription;
}
}
