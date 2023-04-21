package com.ecoveco.VasDatabaseApp.mapper;

import com.ecoveco.VasDatabaseApp.dto.StateDTO;
import com.ecoveco.VasDatabaseApp.entity.State;
import org.springframework.stereotype.Component;

@Component
public class StateMapper {

    public StateDTO toDTO(State state) {
        return new StateDTO(state.getUf(), state.getName());
    }
}
