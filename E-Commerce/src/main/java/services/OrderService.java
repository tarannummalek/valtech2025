package services;

import java.util.List;

import model.Order;

public interface OrderService {

	boolean isOrderPlaced(Order order);

	Order get(int id);

	List<Order> getAll();	

	void update(Order order);

	void delete(int id);

}