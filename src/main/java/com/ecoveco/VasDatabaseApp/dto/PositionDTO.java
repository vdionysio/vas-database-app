package com.ecoveco.VasDatabaseApp.dto;

import com.ecoveco.VasDatabaseApp.entity.Transect;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

public class PositionDTO {
    private Long id;
    private Transect transect;
    private int point;
    private Double latitude;
    private Double longitude;
    private String notes;

    private Long localityId;
    public PositionDTO(Long id, Transect transect, int point, Double latitude, Double longitude, String notes, Long localityId) {
        this.id = id;
        this.transect = transect;
        this.point = point;
        this.latitude = latitude;
        this.longitude = longitude;
        this.notes = notes;
        this.localityId = localityId;
    }

    public Long getId() {
        return id;
    }

    public Transect getTransect() {
        return transect;
    }

    public int getPoint() {
        return point;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getNotes() {
        return notes;
    }

    public Long getLocalityId() {
        return localityId;
    }
}
