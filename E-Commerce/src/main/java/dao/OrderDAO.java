package dao;

import java.util.List;

import model.Order;

public interface OrderDAO {

	void save(Order order);

	Order get(int id);

	List<Order> getAll();

	void update(Order order);

	void delete(int id);

}