package dao;

import java.util.List;

import model.Item;

public interface ItemDAO {

	void save(Item item);

	Item get(int id);

	List<Item> getAll();

	void update(Item item);

	void delete(int id);

}