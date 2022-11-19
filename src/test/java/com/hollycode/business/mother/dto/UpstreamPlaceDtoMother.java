package com.hollycode.business.mother.dto;

import com.hollycode.business.model.dto.UpstreamPlaceDto;

public class UpstreamPlaceDtoMother {

    public static UpstreamPlaceDto complete(String id) {
        return UpstreamPlaceDto.builder()
                .local_entry_id(id)
                .displayed_where("New Orleans")
                .displayed_what("IT")
                .opening_hours(OpeningHoursDtoMother.complete())
                .build();
    }
}
