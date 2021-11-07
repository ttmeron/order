package com.amazon.order.controller.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
public class FinishPurchaseRequest {
    @NotNull
    private Map<Integer,Integer> productIdProductCount;

    @NotEmpty
    private  String userName;

    @NotEmpty
    private  String userLastName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String phone;

    private String address;

    private String comment;
}
