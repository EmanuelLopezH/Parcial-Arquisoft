package com.example.parcial.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(description = "Todos los datos de un pedido.")
@Table(name = "ORDERS")
public class Order {
    @ApiModelProperty(notes = "La base de datos genera un Id para la orden.")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;

    @ApiModelProperty(notes = "Estatus")
    @Column(name = "STATUS")
    private String status;

    @ApiModelProperty(notes = "Fecha y hora de entrega")
    @Column(name = "DELIVERY_DATE")
    private Date deliveryDate;

    @ApiModelProperty(notes = "Id del cliente")
    @Column(name = "CLIENT_ID")
    private Long clientId;

    @ApiModelProperty(notes = "Direccion")
    @Column(name = "ADDRESS")
    private String address;
}
