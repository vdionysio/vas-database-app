package com.ecoveco.VasDatabaseApp.mapper;

import com.ecoveco.VasDatabaseApp.dto.LocalDTO;
import com.ecoveco.VasDatabaseApp.entity.Locality;
import org.springframework.stereotype.Component;

@Component
public class LocalMapper {
    public LocalDTO toDTO(Locality locality) {
        return new LocalDTO(locality.getId(), locality.getName(), locality.getCity().getId());
    }

}
