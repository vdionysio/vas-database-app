package com.ecoveco.VasDatabaseApp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UniqueNameAndCityId", columnNames = {"name", "cityId"})
}
)
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    @OneToMany(mappedBy = "locality")
    private List<Position> positions;

    protected Locality() {
    }

    public Locality(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
