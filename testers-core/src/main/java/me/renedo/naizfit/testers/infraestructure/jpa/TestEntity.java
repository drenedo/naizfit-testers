package me.renedo.naizfit.testers.infraestructure.jpa;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "test")
public class TestEntity {

    @Id
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TesterEntity tester;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProductEntity product;

    private String size;

    public TestEntity() {
    }

    public TestEntity(UUID id, TesterEntity tester, ProductEntity product, String size) {
        this.id = id;
        this.tester = tester;
        this.product = product;
        this.size = size;
    }

    public UUID getId() {
        return id;
    }

    public TesterEntity getTester() {
        return tester;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public String getSize() {
        return size;
    }
}
