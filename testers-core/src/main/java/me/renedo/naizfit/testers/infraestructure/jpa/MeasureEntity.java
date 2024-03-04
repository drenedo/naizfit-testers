package me.renedo.naizfit.testers.infraestructure.jpa;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "measure")
public class MeasureEntity {

    @Id
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = TesterEntity.class)
    @JoinColumn(name = "tester_id", nullable = false)
    private TesterEntity tester;

    @Column(precision = 2)
    private BigDecimal height;

    @Column(precision = 2)
    private BigDecimal weight;

    public MeasureEntity() {
    }

    public MeasureEntity(UUID id, TesterEntity tester, BigDecimal height, BigDecimal weight) {
        this.id = id;
        this.tester = tester;
        this.height = height;
        this.weight = weight;
    }

    public UUID getId() {
        return id;
    }

    public TesterEntity getTester() {
        return tester;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public BigDecimal getWeight() {
        return weight;
    }
}
