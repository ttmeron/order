package com.amazon.order.entity;
import java.util.List;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uId")
    private int id;

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String password;
    @Column
    private String role;
    @Column
    private String address;

    @OneToMany(targetEntity = CustomerOrder.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    private List<CustomerOrder> orders;
//    @OneToMany(targetEntity = PurchaseItem.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private List<PurchaseItem> purchaseItemList;
}
