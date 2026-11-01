package com.starter.demo.lld.dto;

import com.starter.demo.lld.common.enums.VehicleType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.Objects;

public class VehicleDetailsDTO {
    @NotEmpty(message = "Vehicle number plate cannot be empty")
    private String numberPlate;

    @NotNull(message = "Vehicle entry time cannot be null")
    private Timestamp entryTime;

    @NotNull(message = "Vehicle type plate cannot be null")
    private VehicleType vehicleType;

    public String getNumberPlate() {
        return numberPlate;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VehicleDetailsDTO that = (VehicleDetailsDTO) o;
        return Objects.equals(numberPlate, that.numberPlate) && Objects.equals(entryTime, that.entryTime) && vehicleType == that.vehicleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberPlate, entryTime, vehicleType);
    }

    @Override
    public String toString() {
        return "VehicleDetailsDTO{" +
                "numberPlate='" + numberPlate + '\'' +
                ", entryTime=" + entryTime +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
