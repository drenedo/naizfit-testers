package me.renedo.naizfit.testers.application.test;

import java.util.UUID;

public record TestCreatedCommand(UUID id, UUID testerId) {
}
