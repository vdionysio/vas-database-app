package com.ecoveco.VasDatabaseApp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UniqueTransectPointLocalityId", columnNames = {"transect", "point", "localityId"})
}
)
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Transect transect;

    @NotNull
    @Min(0)
    @Max(50)
    private int point;

    @NotNull
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private Double latitude;

    @NotNull
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private Double longitude;

    private String notes;

    @ManyToOne
    @JoinColumn(name = "localityId")
    private Locality locality;

    protected Position() {
    }

    public Position(Transect transect, int point, Double latitude, Double longitude, String notes, Locality locality) {
        this.transect = transect;
        this.point = point;
        this.latitude = latitude;
        this.longitude = longitude;
        this.notes = notes;
        this.locality = locality;
    }

    public Long getId() {
        return id;
    }

    public Transect getTransect() {
        return transect;
    }

    public void setTransect(Transect transect) {
        this.transect = transect;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }
}
