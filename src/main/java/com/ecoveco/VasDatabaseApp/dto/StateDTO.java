package com.ecoveco.VasDatabaseApp.dto;

import com.ecoveco.VasDatabaseApp.entity.State;

public class StateDTO {
    private String uf;
    private String name;

    public StateDTO(String uf, String name) {
        this.uf = uf;
        this.name = name;
    }

    public String getUf() {
        return uf;
    }

    public String getName() {
        return name;
    }
}
