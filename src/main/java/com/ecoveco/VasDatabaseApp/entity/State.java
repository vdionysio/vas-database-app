package com.ecoveco.VasDatabaseApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class State {
    @Id
    private String uf;
    private String name;

    protected State() {}

    public State(String uf, String name) {
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
