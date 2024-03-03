package me.renedo.naizfit.testers.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestsDoneTest {

    @Test
    void should_raise_error_when_tests_done_are_negative() {
        // when
        assertThrows(TestsDoneInvalidException.class, () -> new TestsDone(-1));
    }

    @Test
    void should_construct_when_tests_done_are_ok() {
        // when
        TestsDone testsDone = new TestsDone(0);

        // then
        assertEquals(testsDone.getValue(), 0);
    }
}
