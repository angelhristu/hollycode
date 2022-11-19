package com.hollycode.business.adapter;

import com.hollycode.business.client.UpstreamClient;
import com.hollycode.business.mapper.UpstreamMapper;
import com.hollycode.business.model.domain.Place;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class UpstreamAdapterImpl implements UpstreamAdapter {

    private final UpstreamClient upstreamClient;

    /**
     * Fetches upstream places and converts to place domain
     *
     * @param id id the id for fetching the place
     * @return {@link Place}
     */
    @Override
    public Place retrievePlaceById(String id) {
        return UpstreamMapper.toDomain(upstreamClient.retrievePlaceById(id));
    }
}
