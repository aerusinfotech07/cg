package com.cg.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.crud.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
