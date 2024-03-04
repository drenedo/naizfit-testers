package me.renedo.naizfit.testers.infraestructure.jpa;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    private UUID id;

    private String sku;

    private String sizes;

    private String pictures;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BrandEntity brand;

    private String color;

    public ProductEntity() {

    }

    public ProductEntity(UUID id, String sku, String sizes, String pictures, BrandEntity brand, String color) {
        this.sku = sku;
        this.id = id;
        this.sizes = sizes;
        this.pictures = pictures;
        this.brand = brand;
        this.color = color;
    }

    public UUID getId() {
        return id;
    }

    public String getSizes() {
        return sizes;
    }

    public String getPictures() {
        return pictures;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getSku() {
        return sku;
    }
}
