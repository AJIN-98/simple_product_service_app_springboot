package com.ust.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Converter.DtoConvert;
import com.ust.Exception.OrderNotFoundeException;
import com.ust.Repository.OrderRepository;
import com.ust.dto.OrderDto;
import com.ust.model.productOrder;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository repository;
	@Autowired
	DtoConvert convert;

	@Override
	public boolean placeorder(OrderDto order) {
		try {
			repository.save(convert.dtoToEntity(order));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateorder(OrderDto order) {
		try {
			productOrder ord=repository.getByOrderId(order.getOrderId());
			if(ord!=null) {
				ord.setProductId(order.getProductId());
				ord.setAccountId(order.getAccountId());
				ord.setActive(order.isActive());
				repository.save(ord);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public OrderDto getById(int orderId) throws OrderNotFoundeException {
		try {
			productOrder ord=repository.getByOrderId(orderId);
			return convert.entityToDto(ord);
		} catch (Exception e) {
			throw new OrderNotFoundeException("order Not found !");
		}
		
	}

}
