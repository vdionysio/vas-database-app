package com.ecoveco.VasDatabaseApp.mapper;

import com.ecoveco.VasDatabaseApp.dto.StateDTO;
import com.ecoveco.VasDatabaseApp.entity.State;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StateMapperTest {

    @Test
    @DisplayName("Convert a State Entity to a DTO successfully")
    void testConvertStateToDTO() {
        // given
        StateMapper underTest = new StateMapper();
        State state = new State("SP", "São Paulo");

        // when
        StateDTO stateDTO = underTest.toDTO(state);

        // then
        assertThat(stateDTO).hasOnlyFields("uf", "name");
    }
}