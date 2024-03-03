package me.renedo.naizfit.testers.application;

import java.util.UUID;

public record TestCreatedCommand(UUID id, UUID testerId) {
}
