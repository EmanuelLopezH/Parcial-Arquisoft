package com.example.parcial.DTO;


import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {

    private String status;
    private String name;
    private String address;
    private Date deliveryDate;

}
