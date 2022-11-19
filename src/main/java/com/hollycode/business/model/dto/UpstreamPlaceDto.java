package com.hollycode.business.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UpstreamPlaceDto {

    private String local_entry_id;
    private String displayed_what;
    private String displayed_where;
    private OpeningHoursDto opening_hours;
}
