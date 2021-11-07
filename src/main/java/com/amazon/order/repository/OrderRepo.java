package com.amazon.order.repository;

import com.amazon.order.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<CustomerOrder, Integer> {
}
