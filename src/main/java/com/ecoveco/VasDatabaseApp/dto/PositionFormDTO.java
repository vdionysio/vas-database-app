package com.ecoveco.VasDatabaseApp.dto;

import com.ecoveco.VasDatabaseApp.entity.Transect;
import jakarta.validation.constraints.*;

public class PositionFormDTO {

    @NotNull(message = "transect is required")
    private Transect transect;

    @NotNull(message = "point is required")
    @Min(0)
    @Max(50)
    private int point;

    @NotNull(message = "latitude is required")
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private Double latitude;

    @NotNull(message = "longitude is required")
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private Double longitude;
    private String notes;

    @NotNull
    private Long localityId;

    public PositionFormDTO(Transect transect, int point, Double latitude, Double longitude, String notes, Long localityId ) {
        this.transect = transect;
        this.point = point;
        this.latitude = latitude;
        this.longitude = longitude;
        this.notes = notes;
        this.localityId = localityId;
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
