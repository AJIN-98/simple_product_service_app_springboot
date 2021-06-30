package com.ust.productRepoTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ust.Repository.productRepository;
import com.ust.account.Converter.DtoConvert;
import com.ust.dto.ProductDto;
import com.ust.model.Product;




@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductRepositoryTest {
	
	@Autowired
    private productRepository userRepository;
	
	@Autowired
	DtoConvert convert;

	private ProductDto user =new ProductDto(1, "netflix", "video","100$","yearly");
    
    @Test
    public void getUserByIdTest() {
        userRepository.save(convert.dtoToEntity(user));
        Product fetcheduser = userRepository.getByProductId(user.getProductId());
        Assert.assertEquals(user.getProductId(),fetcheduser.getProductId());

    }


}
