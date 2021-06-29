package com.ust.account.Converter;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.ust.dto.ProductDto;
import com.ust.model.Product;

@Component
public class DtoConvert {
	

public ProductDto entityToDto(Product user) {
		
		ModelMapper mapper =new ModelMapper();
		ProductDto map = mapper.map(user, ProductDto.class);
		return map;
		
	}

public  List<ProductDto> entityToDto(List<Product> student) {
	
	return	student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	
}
public Product dtoToEntity(ProductDto dto)
{
	ModelMapper mapper = new ModelMapper();
	Product map = mapper.map(dto, Product.class);
	return map;
}

public List<Product> dtoToEntity(List<ProductDto> dto)
{

	return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
}


}
