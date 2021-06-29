package com.ust.Converter;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.ust.dto.OrderDto;
import com.ust.model.productOrder;

@Component
public class DtoConvert {
	

public OrderDto entityToDto(productOrder order) {
		
		ModelMapper mapper =new ModelMapper();
		OrderDto map = mapper.map(order, OrderDto.class);
		return map;
		
	}

public  List<OrderDto> entityToDto(List<productOrder> student) {
	
	return	student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	
}
public productOrder dtoToEntity(OrderDto dto)
{
	ModelMapper mapper = new ModelMapper();
	productOrder map = mapper.map(dto, productOrder.class);
	return map;
}

public List<productOrder> dtoToEntity(List<OrderDto> dto)
{

	return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
}


}
