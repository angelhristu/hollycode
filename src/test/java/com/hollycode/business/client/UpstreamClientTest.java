package com.hollycode.business.client;

import com.hollycode.business.exception.PlaceNotFoundException;
import com.hollycode.business.model.dto.UpstreamPlaceDto;
import com.hollycode.business.mother.dto.UpstreamPlaceDtoMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.hollycode.business.TestBase.PLACE_ID_1;
import static com.hollycode.business.client.UpstreamClient.UPSTREAM_PLACES_ENDPOINT;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpstreamClientTest {

    public static final String BASE_URL = "https://storage.googleapis.com";

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UpstreamClient upstreamClient;

    @BeforeEach
    public void beforeEachTest() {
        upstreamClient = new UpstreamClient(BASE_URL, restTemplate);
    }


    @Test
    void retrievePlaceById_success() {
        // GIVEN
        var expectedUpstreamPlaceDto = UpstreamPlaceDtoMother.complete(PLACE_ID_1);
        when(restTemplate.getForObject(format(BASE_URL + UPSTREAM_PLACES_ENDPOINT, PLACE_ID_1), UpstreamPlaceDto.class)).thenReturn(expectedUpstreamPlaceDto);

        // WHEN
        var actualUpstreamPlaceDto = upstreamClient.retrievePlaceById(PLACE_ID_1);

        // THEN
        assertThat(actualUpstreamPlaceDto).isEqualTo(expectedUpstreamPlaceDto);
    }

    @Test
    void retrievePlaceById_throws_PlaceNotFoundException() {
        // GIVEN
        when(restTemplate.getForObject(format(BASE_URL + UPSTREAM_PLACES_ENDPOINT, PLACE_ID_1), UpstreamPlaceDto.class))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // WHEN & THEN
        assertThatThrownBy(() -> upstreamClient.retrievePlaceById(PLACE_ID_1))
                .isInstanceOf(PlaceNotFoundException.class)
                .hasMessage("Place not found for id" + " " + "'" + PLACE_ID_1 + "'.");
    }


}
