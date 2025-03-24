package vo;

import java.util.List;

import model.Order;
import model.Order.Status;

public record OrderVO(long id,Status status,long cust_id,List<Long> lineitems ) {
	

		
		public static OrderVO from (Order order) {
			
			return new OrderVO(order.getId(),order.getStatus(),order.getCustomer().getId(),order.getLineOrderItems().stream().map(l->l.getId()).toList());
			
		}
		
//		public Order to(OrderVO orderVO) {
//			return new Order(id,status,cust_id,lineitems.stream().map())
//		}
	}


