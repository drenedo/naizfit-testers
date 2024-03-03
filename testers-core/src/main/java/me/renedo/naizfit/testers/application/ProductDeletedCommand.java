package me.renedo.naizfit.testers.application;

import java.util.UUID;

public record ProductDeletedCommand(UUID productId, UUID brandId) {
}
