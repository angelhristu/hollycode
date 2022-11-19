package com.hollycode.business.web.controller;

import com.hollycode.business.model.domain.Place;
import com.hollycode.business.service.PlacesService;
import com.hollycode.business.web.api.PlacesApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/places")
public class PlacesController implements PlacesApi{

    private final PlacesService placesService;

    @GetMapping("/{id}")
    public Place retrievePlaceById(@PathVariable String id) {
        log.info("Retrieving Place for id '{}'", id);
        return placesService.retrievePlaceById(id);
    }
}
