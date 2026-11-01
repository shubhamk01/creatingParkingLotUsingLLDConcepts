package com.starter.demo.lld.modals;

import com.starter.demo.lld.common.enums.VehicleType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.Objects;

public class ParkingSpot {
    @Id
    @Column(name = "SPOT_ID")
    private String spotId;
    @Column(name = "VEHICLE_TYPE")
    private VehicleType vehicleType;
    private boolean isAvailable;

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return Objects.equals(spotId, that.spotId) && vehicleType == that.vehicleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(spotId, vehicleType);
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotId='" + spotId + '\'' +
                ", vehicleType=" + vehicleType +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
