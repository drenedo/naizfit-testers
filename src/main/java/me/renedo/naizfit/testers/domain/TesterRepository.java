package me.renedo.naizfit.testers.domain;

import java.util.Optional;
import java.util.UUID;

public interface TesterRepository {

    Optional<Tester> findById(UUID id);
}
