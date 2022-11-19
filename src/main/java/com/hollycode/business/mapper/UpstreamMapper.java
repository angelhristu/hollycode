package com.hollycode.business.mapper;

import com.hollycode.business.model.domain.Place;
import com.hollycode.business.model.dto.UpstreamPlaceDto;

public class UpstreamMapper {

    public static Place toDomain(UpstreamPlaceDto upstreamPlaceDto) {
        return Place.builder()
                .id(upstreamPlaceDto.getLocal_entry_id())
                .businessName(upstreamPlaceDto.getDisplayed_what())
                .address(upstreamPlaceDto.getDisplayed_where())
                .openingHours(OpeningHoursMapper.toDomain(upstreamPlaceDto.getOpening_hours()))
                .build();
    }
}
