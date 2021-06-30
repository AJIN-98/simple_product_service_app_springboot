package com.ust.account.ModelTest;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import com.ust.account.model.User;


public class ModelTest {
	

	  User user = new User("ajin", "achu", "java", 20);

	    @Test
	    public void UserTest() {
	    	try {
	    		 new BeanTester().testBean(User.class);
			} catch (Exception e) {
				
			}
	       
	    }

}
