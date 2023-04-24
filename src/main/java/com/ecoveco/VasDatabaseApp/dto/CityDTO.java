package com.ecoveco.VasDatabaseApp.dto;

import com.ecoveco.VasDatabaseApp.entity.State;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CityDTO {
    private Long id;
    private String name;
    private String uf;

    public CityDTO(Long id, String name, String uf) {
        this.id = id;
        this.name = name;
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUf() {
        return uf;
    }
}
