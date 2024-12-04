package com.example.Nimap_Advanto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank(message = "Product Name is Mandetory")
    private String productName;

    @NotNull(message = "price is mandetory")
    private Double price;


    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

    public void setId(Long id) {
        this.productId = productId;
    }
}
