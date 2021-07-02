package com.ust.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Exception.userNotFoundException;
import com.ust.Repository.SubscriptionRep;
import com.ust.model.Subscription;


@Service
public class SubscriptionImpl implements SubService {
	
	@Autowired
	SubscriptionRep repo;

	@Override
	public boolean addSubscription(Subscription sub) {
		try {
			repo.save(sub);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Subscription getbysubId(int SubId) throws userNotFoundException {
		
		try {
			
			Subscription us=repo.getBySubscriptionId(SubId);
			
			if(us==null) {
				throw new userNotFoundException("user not found");
			}
			return us;
			
			
		} catch (userNotFoundException e) {
			throw new userNotFoundException("user not found");
		}
	}

}
