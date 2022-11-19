package com.hollycode.business.client;

import com.hollycode.business.exception.PlaceNotFoundException;
import com.hollycode.business.model.dto.UpstreamPlaceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpstreamClient {

    @Value("${upstream-base.uri}")
    private final String baseUrl;

    public static final String UPSTREAM_PLACES_ENDPOINT = "/coding-session-rest-api/%s";
    public static final String PLACE_NOT_FOUND_ERROR_MESSAGE = "Place not found for id '%s'.";

    private final RestTemplate restTemplate;

    /**
     * Retrieves upstream places from the upstream api
     *
     * @param id the id for fetching the place
     * @return {@link UpstreamPlaceDto}
     */
    public UpstreamPlaceDto retrievePlaceById(String id) {
        log.debug("Calling upstream api to fetch places for id '{}", id);
        String getUpstreamPlaceByIdEndpoint = baseUrl + UPSTREAM_PLACES_ENDPOINT;

        try {
            return restTemplate.getForObject(format(getUpstreamPlaceByIdEndpoint, id), UpstreamPlaceDto.class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                throw new PlaceNotFoundException(format(PLACE_NOT_FOUND_ERROR_MESSAGE, id));
            }
            throw ex;
        }
    }

}
