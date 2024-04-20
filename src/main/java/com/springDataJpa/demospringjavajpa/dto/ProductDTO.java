package com.springDataJpa.demospringjavajpa.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ProductDTO {
    private Long id;
    private String sku;
    private String description;

    private int stock;

    private BigDecimal price;
    private boolean active;
    private  String imageUrl;

    private LocalDateTime dateCreated;

    private  LocalDateTime lastUpdated;
}
