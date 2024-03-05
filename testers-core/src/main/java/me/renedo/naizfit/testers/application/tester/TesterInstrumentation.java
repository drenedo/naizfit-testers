package me.renedo.naizfit.testers.application.tester;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TesterInstrumentation {
    private static final Logger log = LoggerFactory.getLogger(TesterInstrumentation.class);

    public void notifyError(UUID testerId) {
        log.error("Tester not found {}", testerId);
    }
}
