package com.amazon.order.repository;

import com.amazon.order.entity.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemRepo extends JpaRepository<PurchaseItem,Integer> {
}
