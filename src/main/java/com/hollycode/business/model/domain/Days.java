package com.hollycode.business.model.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
@Builder(toBuilder = true)
public class Days {

    private List<Schedule> monday;
    private List<Schedule> tuesday;
    private List<Schedule> wednesday;
    private List<Schedule> thursday;
    private List<Schedule> friday;
    private List<Schedule> saturday;
    private List<Schedule> sunday;
}
