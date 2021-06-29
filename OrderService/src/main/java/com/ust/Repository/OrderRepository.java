package com.ust.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.model.productOrder;

public interface OrderRepository extends JpaRepository<productOrder, String> {

	productOrder getByOrderId(int orderId);
}
