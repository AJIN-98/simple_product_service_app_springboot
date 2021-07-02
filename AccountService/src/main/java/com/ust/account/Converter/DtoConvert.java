package com.ust.account.Converter;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.ust.account.dto.accountDto;
import com.ust.account.model.User;

@Component
public class DtoConvert {
	
//entity to Dto convert
public accountDto entityToDto(User user) {
		
		ModelMapper mapper =new ModelMapper();
		accountDto map = mapper.map(user, accountDto.class);
		return map;
		
	}

//entity to Dto convert
public  List<accountDto> entityToDto(List<User> student) {
	
	return	student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	
}
//Dto to Entity convert
public User dtoToEntity(accountDto dto)
{
	ModelMapper mapper = new ModelMapper();
	User map = mapper.map(dto, User.class);
	return map;
}

//Dto to Entity convert
public List<User> dtoToEntity(List<accountDto> dto)
{

	return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
}


}
