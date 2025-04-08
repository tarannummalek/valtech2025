package com.valtech.training.ecommerce.services;

import com.valtech.training.ecommerce.entities.Order;
import com.valtech.training.ecommerce.vos.OrderVO;

public interface OrderService {

	boolean isOrderPlaced(OrderVO vo);
//
//	OrderVO createOrder(int quantity);

}