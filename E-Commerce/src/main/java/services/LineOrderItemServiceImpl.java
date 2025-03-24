package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.LineOrderItemDAO;
import model.LineOrderItem;

public class LineOrderItemServiceImpl implements LineOrderItemService {
	
	@Autowired
	LineOrderItemDAO lineOrderItemDAO;
	
	public void setLineOrderItemDAO(LineOrderItemDAO lineOrderItemDAO) {
		this.lineOrderItemDAO = lineOrderItemDAO;
	}

	@Override
	public void save(LineOrderItem item) {
		lineOrderItemDAO.save(item);
	}

	@Override
	public LineOrderItem get(int id) {
		return lineOrderItemDAO.get(id);
	}

	@Override
	public List<LineOrderItem> getAll() {
		return lineOrderItemDAO.getAll();
	}

	@Override
	public void update(LineOrderItem item) {
		lineOrderItemDAO.update(item);
	}

	@Override
	public void delete(int id) {
		lineOrderItemDAO.delete(id);
	}
	
	

}
