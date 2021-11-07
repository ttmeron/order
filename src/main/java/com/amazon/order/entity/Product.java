package com.amazon.order.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Product<Volatile> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pId")
    private int id;
    @Column
    private int amount;

//    boolean setValue = false;
    @Column


    private String pName;
    @Column
    private String PType;
    @Column
    private BigDecimal pPrice;
    @Column
    private String imageUrl;
    @Column
    private String description;
    void Product(int amount){
        this.amount = amount;
    }
//    @OneToMany(targetEntity = PurchaseItem.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<PurchaseItem> purchaseItemList;

//    public synchronized void setAmount(int amount){
//        while (setValue){
//            try {
//                wait();}catch (Exception e){
//            }
//            this.amount = amount;
//            setValue = true;
//            notify();
//        }
//
//    }
//    public synchronized void getAmount(){
//        while (!setValue){
//            try {
//                wait();}catch (Exception e){
//            };
//        }
//        setValue = false;
//        notify();
//    }

}
