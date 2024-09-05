package com.eduardo.productsapirest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity 
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "products")
// @Table(schema = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotBlank(message ="required name field")
    private String name;

    @Column(length = 50)
    @NotNull(message="required price field")
    private double price;
}
