package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ItemDAO;
import dao.ItemDAOImpl;
import model.Item;
@Transactional(propagation = Propagation.SUPPORTS)
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDAO itemDAO;
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void save(Item item) {
		itemDAO.save(item);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Item get(int id) {
		return itemDAO.get(id);
	}

	@Override
	public List<Item> getAll() {
		return itemDAO.getAll();
	}

	@Override
	public void update(Item item) {
		itemDAO.update(item);
	}

	@Override
	public void delete(int id) {
		itemDAO.delete(id);
	}
	
	

}
