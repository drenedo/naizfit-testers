package me.renedo.naizfit.testers.application;

import me.renedo.naizfit.testers.application.tester.TesterDeletedCommand;
import me.renedo.naizfit.testers.domain.Tester;

public class TesterDeletedCommandMother {
    public static TesterDeletedCommand from(Tester tester) {
        return new TesterDeletedCommand(tester.getId());
    }
}
