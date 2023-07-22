package com.ecoveco.VasDatabaseApp.service;

import com.ecoveco.VasDatabaseApp.dto.LocalityFormDTO;
import com.ecoveco.VasDatabaseApp.entity.City;
import com.ecoveco.VasDatabaseApp.entity.State;
import com.ecoveco.VasDatabaseApp.exception.ResourceNotFoundException;
import com.ecoveco.VasDatabaseApp.mapper.LocalityMapper;
import com.ecoveco.VasDatabaseApp.repository.CityRepository;
import com.ecoveco.VasDatabaseApp.repository.LocalityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocalityServiceTest {

    @Mock
    private LocalityRepository localityRepository;

    @Mock
    private CityRepository cityRepository;

    private LocalityMapper localityMapper = new LocalityMapper();

    private LocalityService underTest;

    @BeforeEach
    void setUp() {
        underTest = new LocalityService(localityRepository, localityMapper, cityRepository);
    }

    @Test
    @DisplayName("Get all locals from a given City ID")
    void testGetLocalsByCity() {
        // when
        underTest.getByCityId(4950L);

        // then
        verify(localityRepository).findByCityId(4950L);
    }

    @Test
    @DisplayName("Add a local with valid City Id")
    void testAddLocalWithValidCityId() {
        // Given
        City city = new City("Rio grande", new State("RS", "Rio Grande do Sul"));
        LocalityFormDTO localityFormDTO = new LocalityFormDTO(1L, "Saco do Justino", 4950L);

        // when
        when(cityRepository.findById(anyLong())).thenReturn(Optional.of(city));
        underTest.addLocality(localityFormDTO);

        // then
        verify(localityRepository).save(any());
    }

    @Test
    @DisplayName("Add a local with valid City Id")
    void testAddLocalWithInvalidCityId() {
        // Given
        LocalityFormDTO localityFormDTO = new LocalityFormDTO(1L, "Saco do Justino", 4950L);

        // when
        when(cityRepository.findById(anyLong())).thenReturn(Optional.empty());

        // then
        assertThatThrownBy(() -> underTest.addLocality(localityFormDTO))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("city with id " + localityFormDTO.getCityId() + " does not exists");
        verify(localityRepository, never()).save(any());
    }
}