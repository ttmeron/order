package com.amazon.order.service;

import com.amazon.order.controller.dto.FinishPurchaseRequest;
import com.amazon.order.entity.CustomerOrder;
import com.amazon.order.entity.Product;
import com.amazon.order.entity.PurchaseItem;
import com.amazon.order.exception.NotEnoughProductException;
import com.amazon.order.repository.OrderRepo;
import com.amazon.order.repository.PurchaseItemRepo;
import com.amazon.order.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

@Service
@Slf4j
//@AllArgsConstructor
 public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    UserService userService;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ProductService productService;
    @Autowired
    PurchaseItemRepo purchaseItemRepo;

    @Override
    public String FinishPurchase(FinishPurchaseRequest request) throws NotEnoughProductException {

        CustomerOrder order = new CustomerOrder();
        order.setUser(userService.findOrCreateUser(request.getUserName(),request.getUserLastName(),request.getPhone(),
                request.getEmail(),request.getAddress()));
        orderRepo.save(order);
        order.setComment(request.getComment());
//
        for (Map.Entry<Integer,Integer> entry: request.getProductIdProductCount().entrySet()){
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            Product product = productService.findProductById(k);

            PurchaseItem p = new PurchaseItem();
            if (v > product.getAmount()){
                return "we only have " + product.getAmount()+ " "+ product.getDescription()+ " " + product.getPName();
            }
            product.setAmount(product.getAmount() - v);
            p.setCount(v);
            p.setOrder(order);
            p.setProduct(product);
            purchaseItemRepo.save(p);
        }
        return "your order is placed, we sent verification code to "
                + request.getEmail();
    }

//
//    @Autowired
//    UserService userService;
//    @Autowired
//    private EmailSenderService emailSenderService;
//
//    @Autowired
//    private ProductService productService;
//
////    @Autowired(required = false)
////    private final Product product;
////    @Autowired(required = false)
////    private final PurchaseItem purchaseItem;
//
//    @Autowired
//    OrderRepo orderRepo;
//    @Autowired
//    PurchaseItemRepo purchaseItemRepo;
//    //    @Autowired(required = false)
////    CustomerOrder order;
//    @EventListener()
//    @Override
//    @SneakyThrows
//    public String FinishPurchase(FinishPurchaseRequest request) throws NotEnoughProductException {
//        log.info("creating Customer order entity from request:{}", request);
////       AtomicReference<Integer> result = new AtomicReference<>(0);
//
//        CustomerOrder order = new CustomerOrder();
//
//
//
//        order.setUser(userService.findOrCreateUser(request.getUserName(), request.getUserLastName()
//                , request.getPhone(), request.getEmail(), request.getAddress()));
//        order.setComment(request.getComment());
//
//        orderRepo.save(order);
//
//        for (Map.Entry<Integer, Integer> entry : request.getProductIdProductCount().entrySet()) {
//            Integer k = entry.getKey();
//            Integer v = entry.getValue();
//            System.out.println(v);
//
//            Product product = productService.findProductById(k);
//            if(v > product.getAmount()){
//                System.out.println("we don't have enough product");
//                return "we are sorry we only have " + product.getAmount() + " " + product.getDescription() + " " + product.getPName();
//            }
//            PurchaseItem p = new PurchaseItem();
//
//            p.setCount(v);
//
//            if (product.getAmount() >= p.getCount()) {
//                int sum = product.getAmount() - p.getCount();
//                product.setAmount(sum);
//                p.setProduct(product);
//            }else throw new NotEnoughProductException("we are sorry, we only have " + product.getAmount() +" "+ product.getDescription() +" " + product.getPName() );
//
//
//            p.setOrder(order);
//            purchaseItemRepo.save(p);
////            emailSenderService.sendSimpleEmail(request.getEmail(),"hello mary \n\n\nThank you for being our loyal customer, your order is placed and you order number is " +  order.getId(),"about you");
//            emailSenderService.sendEmailWithAttachment(request.getEmail(),"hello mary \n\n\nThank you for being our loyal customer, your order is placed and you order number is " +  order.getId(),"about you","/Users/merytekle/Desktop/ecxcom.pdf");
//
//        }
//
////        Order order = new Order();
////        order.setUser(userService.findOrCreateUser(
////
////                request.getUserName(),
////                request.getUserLastName(),
////                request.getPhone(),
////                request.getEmail()));
////
//
//
////        return "your order is placed";
//        return "your order is placed and we sent verification code to "+ request.getEmail();
//    }
//
//

}
