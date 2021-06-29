package com.ust.Service;

import com.ust.Exception.OrderNotFoundeException;
import com.ust.dto.OrderDto;

public interface OrderService {

	boolean placeorder(OrderDto order);
	boolean updateorder(OrderDto order);
	OrderDto getById(int orderId) throws OrderNotFoundeException;
}
