package me.renedo.naizfit.testers.application.test;

import java.util.UUID;

public record CreateTestCommand (UUID id, UUID testerId, UUID productId, String size) {
}
