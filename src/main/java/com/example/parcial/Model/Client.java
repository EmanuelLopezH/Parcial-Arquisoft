package com.example.parcial.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Todos los datos de un cliente.")
@Table(name = "CLIENT")
public class Client {
    @ApiModelProperty(notes = "La base de datos genera un Id para el cliente.")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENT_ID")
    private Long clientId;

    @ApiModelProperty(notes = "Primer nombre")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @ApiModelProperty(notes = "Apellido")
    @Column(name = "LAST_NAME")
    private String lastName;
}
