package com.amazon.order.controller;

import com.amazon.order.controller.dto.FinishPurchaseRequest;
import com.amazon.order.controller.dto.FinishPurchaseResponse;
import com.amazon.order.entity.Product;
import com.amazon.order.exception.NotEnoughProductException;
import com.amazon.order.service.ProductService;
import com.amazon.order.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class PurchaseController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    ProductService productService;

    @PostMapping("/finisPurchase")
    public ResponseEntity finishPurchase(@Valid @RequestBody FinishPurchaseRequest request) throws NotEnoughProductException {
        log.info("handling finish purchase request: {}",request);

         String orderId = purchaseService.FinishPurchase(request);

         return ResponseEntity.ok(new FinishPurchaseResponse(orderId));

    }
}
