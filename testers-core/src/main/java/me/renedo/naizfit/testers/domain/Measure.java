package me.renedo.naizfit.testers.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Measure {

    private final UUID id;

    private final LocalDateTime creationDate;

    private final Dimension height;

    private final Dimension weight;

    public Measure(UUID id, LocalDateTime creationDate, Dimension height, Dimension weight) {
        this.id = id;
        this.creationDate = creationDate;
        this.height = height;
        this.weight = weight;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Dimension getHeight() {
        return height;
    }

    public Dimension getWeight() {
        return weight;
    }
}
