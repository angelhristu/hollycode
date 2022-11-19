package com.hollycode.business.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hollycode.business.BusinessApplication;
import com.hollycode.business.exception.ErrorResponse;
import com.hollycode.business.model.domain.Place;
import com.hollycode.business.mother.domain.PlaceMother;
import com.hollycode.business.mother.dto.UpstreamPlaceDtoMother;
import io.restassured.RestAssured;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static com.hollycode.business.TestBase.PLACE_ID_1;
import static com.hollycode.business.client.UpstreamClient.UPSTREAM_PLACES_ENDPOINT;
import static com.hollycode.business.client.UpstreamClientTest.BASE_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = BusinessApplication.class)
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class PlacesControllerIT {

    private static final String RETRIEVE_PLACE_URI = "/places/%s";

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
        objectMapper = Jackson2ObjectMapperBuilder.json().build();
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }


    @Test
    @SneakyThrows
    void retrievePlaceById_success() {

        var expectedUpstreamPlaceDto = UpstreamPlaceDtoMother.complete(PLACE_ID_1);
        var upstreamURI = new URI(format(BASE_URL + UPSTREAM_PLACES_ENDPOINT, PLACE_ID_1));

        mockServer.expect(ExpectedCount.once(),
                        requestTo(upstreamURI))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(objectMapper.writeValueAsString(expectedUpstreamPlaceDto))
                );


        Place actual = given()
                .contentType(JSON)
                .when()
                .get(format(RETRIEVE_PLACE_URI, PLACE_ID_1))
                .then()
                .statusCode(OK.value())
                .extract().as(Place.class);

        assertThat(actual).isEqualTo(PlaceMother.complete(PLACE_ID_1));
    }

    @Test
    @SneakyThrows
    void retrievePlaceById_notFound() {

        var upstreamURI = new URI(format(BASE_URL + UPSTREAM_PLACES_ENDPOINT, PLACE_ID_1));

        mockServer.expect(ExpectedCount.once(),
                        requestTo(upstreamURI))
                .andExpect(method(HttpMethod.GET))
                .andRespond( response -> { throw new HttpClientErrorException(HttpStatus.NOT_FOUND);});


        ErrorResponse errorResponse = given()
                .contentType(JSON)
                .when()
                .get(format(RETRIEVE_PLACE_URI, PLACE_ID_1))
                .then()
                .statusCode(NOT_FOUND.value())
                .extract().as(ErrorResponse.class);

        assertThat(errorResponse.getStatus()).isEqualTo(NOT_FOUND);
    }


}
