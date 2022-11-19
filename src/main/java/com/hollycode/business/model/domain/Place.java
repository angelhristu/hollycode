package com.hollycode.business.model.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
public class Place {

    private String id;
    private String businessName;
    private String address;
    private OpeningHours openingHours;
}
