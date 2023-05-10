package com.ecoveco.VasDatabaseApp.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "uf")
    private State state;
    @OneToMany(mappedBy = "city")
    private List<Local> locals;

    protected City() {
    }

    public City(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public City(Long id, String name, State state) {
        this.name = name;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public List<Local> getLocals() {
        return locals;
    }
}
