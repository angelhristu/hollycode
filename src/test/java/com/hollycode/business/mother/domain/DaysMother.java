package com.hollycode.business.mother.domain;

import com.hollycode.business.model.domain.Days;

import java.util.List;

public class DaysMother {

    public static Days complete() {
        return Days.builder()
                .monday(List.of(ScheduleMother.completeMonday()))
                .tuesday(List.of(ScheduleMother.completeTuesday()))
                .wednesday(List.of(ScheduleMother.completeWednesday()))
                .thursday(List.of(ScheduleMother.completeThursday()))
                .friday(List.of(ScheduleMother.completeFriday()))
                .saturday(List.of(ScheduleMother.completeSaturday()))
                .sunday(List.of(ScheduleMother.completeSunday()))
                .build();
    }
}
