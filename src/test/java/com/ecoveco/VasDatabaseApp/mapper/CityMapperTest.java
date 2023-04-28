package com.ecoveco.VasDatabaseApp.mapper;

import com.ecoveco.VasDatabaseApp.dto.CityDTO;
import com.ecoveco.VasDatabaseApp.dto.StateDTO;
import com.ecoveco.VasDatabaseApp.entity.City;
import com.ecoveco.VasDatabaseApp.entity.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CityMapperTest {

    @Test
    @DisplayName("Convert a City Entity to a DTO successfully")
    void testConvertCityToDTO() {
        // given
        CityMapper underTest = new CityMapper();
        State state = new State("SP", "São Paulo");
        City city = new City("Botucatu", state);

        // when
        CityDTO cityDTO = underTest.toDTO(city);

        // then
        assertThat(cityDTO).hasOnlyFields("id", "name", "uf");
        assertThat(cityDTO.getUf()).isEqualTo("SP");
    }

}