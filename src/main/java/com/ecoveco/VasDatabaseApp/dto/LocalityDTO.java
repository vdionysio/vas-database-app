package com.ecoveco.VasDatabaseApp.dto;

public class LocalityDTO {
    private Long id;
    private String name;
    private Long cityId;

    public LocalityDTO(Long id, String name, Long cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCityId() {
        return cityId;
    }
}
