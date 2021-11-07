package com.amazon.order.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FinishPurchaseResponse {
    private String orderId;
}
