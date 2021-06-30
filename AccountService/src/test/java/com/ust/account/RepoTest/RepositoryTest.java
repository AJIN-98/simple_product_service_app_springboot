package com.ust.account.RepoTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ust.account.Converter.DtoConvert;
import com.ust.account.dto.accountDto;
import com.ust.account.model.User;
import com.ust.account.repository.AccountRepository;



@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RepositoryTest {
	
	@Autowired
    private AccountRepository userRepository;
	
	@Autowired
	DtoConvert convert;

    accountDto user = new accountDto(1,"ajin", "achu", "007a",12);
    
    @Test
    public void getUserByIdTest() {
        userRepository.save(convert.dtoToEntity(user));
        User fetcheduser = userRepository.getByAccountId(user.getAccountId());
        Assert.assertEquals(user.getAccountId(),fetcheduser.getAccountId());

    }


}
