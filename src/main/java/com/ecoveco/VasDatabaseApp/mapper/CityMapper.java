package com.ecoveco.VasDatabaseApp.mapper;

import com.ecoveco.VasDatabaseApp.dto.CityDTO;
import com.ecoveco.VasDatabaseApp.entity.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    public CityDTO toDTO(City city) {
        return new CityDTO(city.getId(), city.getName(), city.getState().getUf());
    }
}
