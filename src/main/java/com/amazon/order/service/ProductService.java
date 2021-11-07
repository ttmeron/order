package com.amazon.order.service;


import com.amazon.order.entity.Product;
import com.amazon.order.exception.NotEnoughProductException;

import java.util.List;

public interface ProductService {
    public List<Product> findAllProduct();
    public Product findProductById(Integer id);
    public void updateProduct(Product product) throws NotEnoughProductException;
}
