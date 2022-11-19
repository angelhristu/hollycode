package com.hollycode.business.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
@Builder(toBuilder = true)
public class DaysDto {

    private List<ScheduleDto> monday;
    private List<ScheduleDto> tuesday;
    private List<ScheduleDto> wednesday;
    private List<ScheduleDto> thursday;
    private List<ScheduleDto> friday;
    private List<ScheduleDto> saturday;
    private List<ScheduleDto> sunday;
}
