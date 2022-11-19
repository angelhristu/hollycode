package com.hollycode.business.mother.domain;

import com.hollycode.business.model.domain.OpeningHours;

public class OpeningHoursMother {

    public static OpeningHours complete() {
        return OpeningHours.builder()
                .days(DaysMother.complete())
                .build();
    }
}
