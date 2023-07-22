package com.ecoveco.VasDatabaseApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LocalityFormDTO {
    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "city id is required")
    private Long cityId;

    public LocalityFormDTO(Long id, String name, Long cityId) {
        this.name = name;
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public Long getCityId() {
        return cityId;
    }
}
