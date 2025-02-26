package services;

import java.util.List;

import model.LineOrderItem;

public interface LineOrderItemService {

	void save(LineOrderItem item);

	LineOrderItem get(int id);

	List<LineOrderItem> getAll();

	void update(LineOrderItem item);

	void delete(int id);

}