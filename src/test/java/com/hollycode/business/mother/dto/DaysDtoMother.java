package com.hollycode.business.mother.dto;

import com.hollycode.business.model.dto.DaysDto;

import java.util.List;

public class DaysDtoMother {

    public static DaysDto complete() {
        return DaysDto.builder()
                .monday(List.of(ScheduleDtoMother.completeMonday()))
                .tuesday(List.of(ScheduleDtoMother.completeTuesday()))
                .wednesday(List.of(ScheduleDtoMother.completeWednesday()))
                .thursday(List.of(ScheduleDtoMother.completeThursday()))
                .friday(List.of(ScheduleDtoMother.completeFriday()))
                .saturday(List.of(ScheduleDtoMother.completeSaturday()))
                .sunday(List.of(ScheduleDtoMother.completeSunday()))
                .build();
    }
}
