package com.hollycode.business.mapper;

import com.hollycode.business.model.domain.OpeningHours;
import com.hollycode.business.model.dto.OpeningHoursDto;

public class OpeningHoursMapper {

    public static OpeningHours toDomain(OpeningHoursDto openingHours) {
        return OpeningHours.builder()
                .days(DaysMapper.toDomain(openingHours.getDays()))
                .build();
    }
}
