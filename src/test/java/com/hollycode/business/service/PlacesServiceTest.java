package com.hollycode.business.service;

import com.hollycode.business.adapter.UpstreamAdapter;
import com.hollycode.business.mother.domain.PlaceMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.hollycode.business.TestBase.PLACE_ID_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlacesServiceTest {

    @Mock
    private UpstreamAdapter upstreamAdapter;

    @InjectMocks
    private PlacesService placesService;

    @Test
    void retrievePlaceById_success() {
        // GIVEN
        var expectedPlace = PlaceMother.complete(PLACE_ID_1);
        when(upstreamAdapter.retrievePlaceById(PLACE_ID_1)).thenReturn(expectedPlace);

        // WHEN
        var actualPlace = placesService.retrievePlaceById(PLACE_ID_1);

        // THEN
        assertThat(actualPlace).isEqualTo(expectedPlace);
    }


}
