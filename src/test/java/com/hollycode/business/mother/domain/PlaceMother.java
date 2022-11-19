package com.hollycode.business.mother.domain;

import com.hollycode.business.model.domain.Place;

public class PlaceMother {

    public static Place complete(String id) {
        return Place.builder()
                .id(id)
                .address("New Orleans")
                .businessName("IT")
                .openingHours(OpeningHoursMother.complete())
                .build();
    }
}
