package com.ecoveco.VasDatabaseApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class State {
    @Id
    private String uf;
    private String name;

    @OneToMany(mappedBy = "state")
    private List<City> cities;

    protected State() {
    }

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

    public List<City> getCities() {
        return cities;
    }
}
