package com.amazon.order.controller;

import com.amazon.order.entity.Product;
import com.amazon.order.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        log.info("handling get all products request");
        return productService.findAllProduct();
    }

    @GetMapping("/product/{pId}")
    public Product getProductById(@PathVariable Integer pId)
    {
        log.info("handling get product by id:{}",pId);
        return productService.findProductById(pId);
    }
}
