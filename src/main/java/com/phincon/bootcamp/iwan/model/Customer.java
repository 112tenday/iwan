package com.phincon.bootcamp.iwan.model;

import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private String id;
    private String name;
    private String status;
    private Timestamp createdDate;
    private Timestamp updateDate;

}
