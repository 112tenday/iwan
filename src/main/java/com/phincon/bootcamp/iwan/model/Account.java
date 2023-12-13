package com.phincon.bootcamp.agung.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Accounts")
@Entity
public class Account {

    @Id

    String customerId;
    String id;
    String name;
    String type;
    String status;
    Long amount;
    Timestamp createdDate;
    Timestamp updateDate;

}
