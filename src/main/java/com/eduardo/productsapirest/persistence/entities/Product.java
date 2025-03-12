package com.eduardo.productsapirest.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "products")
// @Table(schema = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Name can only contain letters, numbers, and spaces")
    @NotBlank(message ="required name field")
    private String name;

    @Column(length = 50)
    @NotNull(message="required price field")
    private Double price;
    //new
    @NotNull(message="requires quatity of products field")
    private Long quantityOfProducts;
    @NotNull(message="requires the registration date field")
    private LocalDate date;
}
