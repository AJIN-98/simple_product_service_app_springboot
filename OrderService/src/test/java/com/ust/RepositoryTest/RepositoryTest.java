package com.ust.RepositoryTest;

import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ust.Converter.DtoConvert;
import com.ust.Repository.OrderRepository;
import com.ust.dto.OrderDto;
import com.ust.model.productOrder;





@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RepositoryTest {
	
	@Autowired
    private OrderRepository userRepository;
	
	@Autowired
	DtoConvert convert;
    
    @Test
    public void getUserByIdTest() {
    	OrderDto user =new OrderDto(1, 22, 33,true);
        userRepository.save(convert.dtoToEntity(user));
        productOrder fetcheduser =  userRepository.getByOrderId((user.getOrderId())) ;
        Assert.assertEquals(user.getOrderId(),fetcheduser.getOrderId());

    }


}
