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

    /*
    id   UUID PRIMARY KEY,
    tester_id UUID NOT NULL
    CONSTRAINT test_tester_fk references tester (id),
    product_id UUID NOT NULL
    CONSTRAINT test_product_fk references product (id),
    size TEXT NOT NULL
     */

    @Id
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TesterEntity tester;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductEntity product;

    private String size;
}
