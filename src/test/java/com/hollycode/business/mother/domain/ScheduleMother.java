package com.hollycode.business.mother.domain;

import com.hollycode.business.model.domain.Schedule;

public class ScheduleMother {

    public static Schedule completeMonday() {
        return Schedule.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }

    public static Schedule completeTuesday() {
        return Schedule.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }

    public static Schedule completeWednesday() {
        return Schedule.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }

    public static Schedule completeThursday() {
        return Schedule.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }

    public static Schedule completeFriday() {
        return Schedule.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }

    public static Schedule completeSaturday() {
        return Schedule.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }

    public static Schedule completeSunday() {
        return Schedule.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }
}
