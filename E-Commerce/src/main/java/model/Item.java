package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Item {
	
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "itemseq")
	@SequenceGenerator(name = "itemseq", sequenceName = "item_seq" ,allocationSize = 1)
	private long id;
	
	private String name;
	
	private String description;
	
	private int reorderLevel;
	
	private int max_quantity;
	
	private int cur_quantity;
	
	@OneToMany(targetEntity = LineOrderItem.class,mappedBy = "item",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	 Set<LineOrderItem> lineOrderItems;
	

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item( String name, String description, int reorderLevel, int max_quantity,int cur_quantity) {
		
		this.name = name;
		this.description = description;
		this.reorderLevel = reorderLevel;
		this.max_quantity = max_quantity;
		this.cur_quantity=cur_quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public int getMax_quantity() {
		return max_quantity;
	}

	public void setMax_quantity(int max_quantity) {
		this.max_quantity = max_quantity;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", reorderLevel=" + reorderLevel
				+ ", max_quantity=" + max_quantity + "]";
	}
//	public void setOredrs(Set<Order> oredrs) {
//		this.orders = oredrs;
//	}
//	public Set<Order> getOredrs() {
//		return orders;
//	}

	public int getCur_quantity() {
		return cur_quantity;
	}

	public void setCur_quantity(int cur_quantity) {
		this.cur_quantity = cur_quantity;
	}

//	public Set<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Set<Order> orders) {
//		this.orders = orders;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<LineOrderItem> getLineOrderItems() {
		return lineOrderItems;
	}

	public void setLineOrderItems(Set<LineOrderItem> lineOrderItems) {
		this.lineOrderItems = lineOrderItems;
	}
	
	
	

}
