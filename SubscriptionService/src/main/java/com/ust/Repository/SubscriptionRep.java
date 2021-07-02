package com.ust.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.model.Subscription;

public interface SubscriptionRep extends JpaRepository<Subscription, String>{

	Subscription getBySubscriptionId(int SubscriptionId);
}
