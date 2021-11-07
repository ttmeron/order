package com.amazon.order.service;

import com.amazon.order.entity.Product;
import com.amazon.order.exception.NotEnoughProductException;
import com.amazon.order.exception.NotFoundException;
import com.amazon.order.repository.ProductRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> findAllProduct() {
        return productRepo.findAll();
    }

    @Override
    @SneakyThrows
    public Product findProductById(Integer id) {

        return productRepo.findById(id)
                .orElseThrow(()-> new NotFoundException("Product not found "));
    }

    @Override
//    @SneakyThrows
    public void updateProduct(Product product)  {
//        Product oldProduct = productRepo.findById(product.getId()).get();
//        if (product.getAmount() > oldProduct.getAmount()) {
//             throw new NotEnoughProductException("no");
//        }
        productRepo.save(product);
//        new NotEnoughProductException("no");

    }
}
