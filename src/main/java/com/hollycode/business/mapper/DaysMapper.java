package com.hollycode.business.mapper;

import com.hollycode.business.model.domain.Days;
import com.hollycode.business.model.dto.DaysDto;

public class DaysMapper {

    public static Days toDomain(DaysDto days) {
        return Days.builder()
                .monday(days.getMonday() != null ? days.getMonday().stream().map(ScheduleMapper::toDto).toList() : null)
                .tuesday(days.getTuesday() != null ? days.getTuesday().stream().map(ScheduleMapper::toDto).toList() : null)
                .wednesday(days.getWednesday() != null ? days.getWednesday().stream().map(ScheduleMapper::toDto).toList() : null)
                .thursday(days.getThursday() != null ? days.getThursday().stream().map(ScheduleMapper::toDto).toList() : null)
                .friday(days.getFriday() != null ? days.getFriday().stream().map(ScheduleMapper::toDto).toList() : null)
                .saturday(days.getSaturday() != null ? days.getSaturday().stream().map(ScheduleMapper::toDto).toList() : null)
                .sunday(days.getSunday() != null ? days.getSunday().stream().map(ScheduleMapper::toDto).toList() : null)
                .build();
    }
}
