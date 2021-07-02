package com.ust.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


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
	static int id = 0;
	
	private String SUBSCRIPTION_SERVICE_ADD = "http://localhost:9097/sub/add";
	@Override
	public boolean placeorder(OrderDto order) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			repository.save(convert.dtoToEntity(order));
			
			List<productOrder> l = repository.findAll();
			
			l.stream().filter(o -> o.getAccountId() == order.getAccountId() && o.getProductId()==order.getProductId()).forEach(i -> id = i.getOrderId());
//			headers.add("Authentication", head);
			
			
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			String body = "{\"accountId\":\""+ order.getAccountId() +"\",\"productId\":\""+ order.getProductId()+"\"}" ;
			HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
			
			ResponseEntity<String> responseEntity = restTemplate.exchange(
					SUBSCRIPTION_SERVICE_ADD,
	                HttpMethod.POST,
	                requestEntity,
	                String.class
	        );
			if(responseEntity.getStatusCode() == HttpStatus.CREATED) {
				return true;
			}
			repository.delete(convert.dtoToEntity(order));
			return false;
		}
		catch (Exception e) {
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
