package com.capg.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
