package com.amazon.order.service;

import com.amazon.order.controller.dto.FinishPurchaseRequest;
import com.amazon.order.exception.NotEnoughProductException;

public interface PurchaseService {

    // it will return number of order
    public String FinishPurchase(FinishPurchaseRequest request) throws NotEnoughProductException;

}
