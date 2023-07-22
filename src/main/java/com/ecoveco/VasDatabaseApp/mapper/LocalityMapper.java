package com.ecoveco.VasDatabaseApp.mapper;

import com.ecoveco.VasDatabaseApp.dto.LocalityDTO;
import com.ecoveco.VasDatabaseApp.entity.Locality;
import org.springframework.stereotype.Component;

@Component
public class LocalityMapper {
    public LocalityDTO toDTO(Locality locality) {
        return new LocalityDTO(locality.getId(), locality.getName(), locality.getCity().getId());
    }

}
