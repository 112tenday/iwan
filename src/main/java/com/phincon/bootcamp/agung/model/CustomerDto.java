package com.phincon.bootcamp.agung.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerDto {

    @NotBlank(message = "id mandatory")

    String id;

    String customerId;
    String name;
    String status;
    Long amount;
}
