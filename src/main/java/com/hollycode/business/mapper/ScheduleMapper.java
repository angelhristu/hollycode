package com.hollycode.business.mapper;

import com.hollycode.business.model.domain.Schedule;
import com.hollycode.business.model.dto.ScheduleDto;

public class ScheduleMapper {

    public static Schedule toDto(ScheduleDto scheduleDto) {
        return Schedule.builder()
                .start(scheduleDto.getStart())
                .end(scheduleDto.getEnd())
                .type(scheduleDto.getType())
                .build();
    }
}
