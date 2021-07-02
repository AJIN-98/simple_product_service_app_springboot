package com.ust.Service;

import com.ust.Exception.userNotFoundException;
import com.ust.model.Subscription;

public interface SubService {

	boolean addSubscription(Subscription sub);
	Subscription getbysubId(int SubId) throws userNotFoundException;
}