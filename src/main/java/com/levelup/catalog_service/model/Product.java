package com.levelup.catalog_service.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1000)
    private String description;

    private BigDecimal price;

    private String imageUrl;

    private Integer stock;

    private String platform; // PC, PS5, etc.

    public Product() {
    }

    public Product(String name, String description, BigDecimal price,
                   String imageUrl, Integer stock, String platform) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.stock = stock;
        this.platform = platform;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
