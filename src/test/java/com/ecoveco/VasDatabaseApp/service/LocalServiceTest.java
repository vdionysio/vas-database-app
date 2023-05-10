package com.ecoveco.VasDatabaseApp.service;

import com.ecoveco.VasDatabaseApp.dto.LocalDTO;
import com.ecoveco.VasDatabaseApp.dto.LocalFormDTO;
import com.ecoveco.VasDatabaseApp.entity.City;
import com.ecoveco.VasDatabaseApp.entity.State;
import com.ecoveco.VasDatabaseApp.exception.ResourceNotFoundException;
import com.ecoveco.VasDatabaseApp.mapper.LocalMapper;
import com.ecoveco.VasDatabaseApp.repository.CityRepository;
import com.ecoveco.VasDatabaseApp.repository.LocalRepository;
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
class LocalServiceTest {

    @Mock
    private LocalRepository localRepository;

    @Mock
    private CityRepository cityRepository;

    private LocalMapper localMapper = new LocalMapper();

    private LocalService underTest;

    @BeforeEach
    void setUp() {
        underTest = new LocalService(localRepository, localMapper, cityRepository);
    }

    @Test
    @DisplayName("Get all locals from a given City ID")
    void testGetLocalsByCity() {
        // when
        underTest.getByCity(4950L);

        // then
        verify(localRepository).findByCityId(4950L);
    }

    @Test
    @DisplayName("Add a local with valid City Id")
    void testAddLocalWithValidCityId() {
        // Given
        City city = new City("Rio grande", new State("RS", "Rio Grande do Sul"));
        LocalFormDTO localFormDTO = new LocalFormDTO(1L, "Saco do Justino", 4950L);

        // when
        when(cityRepository.findById(anyLong())).thenReturn(Optional.of(city));
        underTest.addLocal(localFormDTO);

        // then
        verify(localRepository).save(any());
    }

    @Test
    @DisplayName("Add a local with valid City Id")
    void testAddLocalWithInvalidCityId() {
        // Given
        LocalFormDTO localFormDTO = new LocalFormDTO(1L, "Saco do Justino", 4950L);

        // when
        when(cityRepository.findById(anyLong())).thenReturn(Optional.empty());

        // then
        assertThatThrownBy(() -> underTest.addLocal(localFormDTO))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("city with id " + localFormDTO.getCityId() + " does not exists");
        verify(localRepository, never()).save(any());
    }
}