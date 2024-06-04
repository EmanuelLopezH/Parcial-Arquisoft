package com.example.parcial.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDTO {

    private String status;
    private String name;
    private String address;
    private String deliveryDate;

}
