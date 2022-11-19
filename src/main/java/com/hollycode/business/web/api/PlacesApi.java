package com.hollycode.business.web.api;

import com.hollycode.business.model.domain.Place;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Places Controller")
public interface PlacesApi {

    @Operation(summary = "Retrieve a place entity for a given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Place entity retrieved"),
            @ApiResponse(responseCode = "404", description = "Place entity not found"),
            @ApiResponse(responseCode = "500", description = "Internal Error")
    })
    @Parameter(name = "id", description = "The id for a place entity")
    Place retrievePlaceById(String id);
}
