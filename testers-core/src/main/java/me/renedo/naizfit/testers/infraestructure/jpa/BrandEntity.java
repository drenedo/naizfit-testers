package me.renedo.naizfit.testers.infraestructure.jpa;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "brand")
public class BrandEntity {

    @Id
    private UUID id;

    private String name;

    private String logo;

    public BrandEntity() {
    }

    public BrandEntity(UUID id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }
}
