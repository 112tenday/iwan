package com.phincon.bootcamp.iwan.model;

import lombok.Data;

@Data
public class AccountDto {

    String id;
    String customerId;
    String name;
    String type;
    String status;
    Long amount;

}
