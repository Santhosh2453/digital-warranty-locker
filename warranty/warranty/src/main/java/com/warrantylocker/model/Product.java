package com.warrantylocker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String category;

    private LocalDate purchaseDate;
    private LocalDate warrantyExpiry;

    private String billImageUrl;

    // Constructors
    public Product() {}

    public Product(String name, String brand, String category, LocalDate purchaseDate, LocalDate warrantyExpiry, String billImageUrl) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.warrantyExpiry = warrantyExpiry;
        this.billImageUrl = billImageUrl;
    }

    // Getters & Setters (you can use Lombok if preferred)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public LocalDate getWarrantyExpiry() { return warrantyExpiry; }
    public void setWarrantyExpiry(LocalDate warrantyExpiry) { this.warrantyExpiry = warrantyExpiry; }

    public String getBillImageUrl() { return billImageUrl; }
    public void setBillImageUrl(String billImageUrl) { this.billImageUrl = billImageUrl; }
}
