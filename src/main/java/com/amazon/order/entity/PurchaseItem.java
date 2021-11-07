package com.amazon.order.entity;


import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "piId")
    private int id;

    @Column
    private int count;

    @ManyToOne
    @JoinColumn(name = "Fk_pId",referencedColumnName = "pId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Fk_oId",referencedColumnName = "oId")
    private CustomerOrder order;
}
