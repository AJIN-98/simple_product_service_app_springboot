package com.ust.AccountServiceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.ust.account.AccountServiceApplication;
import com.ust.account.Service.AccountService;
import com.ust.account.model.User;
import com.ust.account.repository.AccountRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountServiceApplication.class)
public class AccountServiceApplicationTest {
	
	@Autowired
	private AccountService service;
	
	@MockBean
	private AccountRepository repository;
	
//	@Test
//	public void addUserTest() {
//		User user = new User("abc", "de", "ijklmn", 20);
//		when(repository.save(user)).thenReturn(user);
//		assertEquals(true, service.addUser(user));
//	}
}
