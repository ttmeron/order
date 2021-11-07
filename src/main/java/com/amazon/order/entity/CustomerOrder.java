package com.amazon.order.entity;

import lombok.*;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "oId")
    private int id;

    @Column
    private String comment;

    @ManyToOne
   @JoinColumn(name = "Fk_uId", referencedColumnName = "uId")

    private User user;
}
