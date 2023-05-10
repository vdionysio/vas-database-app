package com.ecoveco.VasDatabaseApp.mapper;

import com.ecoveco.VasDatabaseApp.dto.LocalDTO;
import com.ecoveco.VasDatabaseApp.entity.City;
import com.ecoveco.VasDatabaseApp.entity.Local;
import com.ecoveco.VasDatabaseApp.entity.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LocalMapperTest {

    @Test
    @DisplayName("Convert a Local Entity to a DTO successfully")
    void testConvertLocalToDTO() {
        // given
        LocalMapper underTest = new LocalMapper();
        State state = new State("RS", "Rio Grande do Sul");
        City city = new City(1L, "Rio Grande", state);
        Local local = new Local("Saco da Mangueira", city);

        // when
        LocalDTO localDTO = underTest.toDTO(local);

        // then
        assertThat(localDTO).hasOnlyFields("id", "name", "cityId");
    }
}