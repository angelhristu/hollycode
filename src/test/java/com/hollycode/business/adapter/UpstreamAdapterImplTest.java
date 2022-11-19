package com.hollycode.business.adapter;

import com.hollycode.business.client.UpstreamClient;
import com.hollycode.business.mapper.UpstreamMapper;
import com.hollycode.business.mother.dto.UpstreamPlaceDtoMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.hollycode.business.TestBase.PLACE_ID_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpstreamAdapterImplTest {

    @Mock
    private UpstreamClient upstreamClient;

    @InjectMocks
    private UpstreamAdapterImpl upstreamAdapterImpl;

    @Test
    void retrievePlaceById_success() {
        // GIVEN
        var expectedUpstreamPlaceDto = UpstreamPlaceDtoMother.complete(PLACE_ID_1);
        var expectedPlace = UpstreamMapper.toDomain(expectedUpstreamPlaceDto);
        when(upstreamClient.retrievePlaceById(PLACE_ID_1)).thenReturn(expectedUpstreamPlaceDto);

        // WHEN
        var actualPlace = upstreamAdapterImpl.retrievePlaceById(PLACE_ID_1);

        // THEN
        assertThat(actualPlace).isEqualTo(expectedPlace);
    }


}
