package com.hollycode.business.mother.dto;

import com.hollycode.business.model.dto.OpeningHoursDto;

public class OpeningHoursDtoMother {

    public static OpeningHoursDto complete() {
        return OpeningHoursDto.builder()
                .days(DaysDtoMother.complete())
                .build();
    }
}
