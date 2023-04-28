package com.ecoveco.VasDatabaseApp.service;

import com.ecoveco.VasDatabaseApp.mapper.CityMapper;
import com.ecoveco.VasDatabaseApp.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    private CityMapper cityMapper = new CityMapper();

    private CityService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CityService(cityRepository, cityMapper);
    }

    @Test
    @DisplayName("Get all cities from a given UF")
    void testGetCitiesByUf() {
        // when
        underTest.getByUf("BA");

        // then
        verify(cityRepository).findByStateUf("BA");
    }
}