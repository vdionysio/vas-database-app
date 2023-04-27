package com.ecoveco.VasDatabaseApp.mapper;

import com.ecoveco.VasDatabaseApp.dto.LocalDTO;
import com.ecoveco.VasDatabaseApp.dto.LocalFormDTO;
import com.ecoveco.VasDatabaseApp.entity.Local;
import org.springframework.stereotype.Component;

@Component
public class LocalMapper {
    public LocalDTO toDTO(Local local) {
        return new LocalDTO(local.getId(), local.getName(), local.getCity().getId());
    }

}
