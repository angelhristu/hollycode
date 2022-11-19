package com.hollycode.business.mother.dto;

import com.hollycode.business.model.dto.ScheduleDto;

public class ScheduleDtoMother {

    public static ScheduleDto completeMonday() {
        return ScheduleDto.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }

    public static ScheduleDto completeTuesday() {
        return ScheduleDto.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }

    public static ScheduleDto completeWednesday() {
        return ScheduleDto.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }

    public static ScheduleDto completeThursday() {
        return ScheduleDto.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }

    public static ScheduleDto completeFriday() {
        return ScheduleDto.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }

    public static ScheduleDto completeSaturday() {
        return ScheduleDto.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }

    public static ScheduleDto completeSunday() {
        return ScheduleDto.builder()
                .start("11:30")
                .end("15:00")
                .type("OPEN")
                .build();
    }
}
