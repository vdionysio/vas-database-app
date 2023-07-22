package com.ecoveco.VasDatabaseApp.mapper;

import com.ecoveco.VasDatabaseApp.dto.PositionDTO;
import com.ecoveco.VasDatabaseApp.entity.Position;
import org.springframework.stereotype.Component;

@Component
public class PositionMapper {
    public PositionDTO toDto(Position position) {
        return new PositionDTO(position.getId(), position.getTransect(), position.getPoint(), position.getLatitude(), position.getLongitude(), position.getNotes(), position.getLocality().getId());
    }
}
