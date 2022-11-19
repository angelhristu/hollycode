package com.hollycode.business.service;

import com.hollycode.business.adapter.UpstreamAdapter;
import com.hollycode.business.model.domain.Place;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlacesService {

    private final UpstreamAdapter upstreamAdapter;

    /**
     * Retrieves Places by the id
     *
     * @param id the id for fetching the place
     * @return {@link Place}
     */
    public Place retrievePlaceById(String id) {
        return upstreamAdapter.retrievePlaceById(id);
    }

}
