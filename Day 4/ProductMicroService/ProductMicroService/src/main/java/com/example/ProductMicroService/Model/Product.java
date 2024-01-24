package com.example.ProductMicroService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
public class Product {
    @Id
    private String Id;
    private int quantity;
    private String productName;
    private Category category;
    private Double price;
    private LocalDate expirydate;
}
