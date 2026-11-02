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

    @NotNull(message = "Vehicle exit time cannot be null")
    private Timestamp exitTime;

    @NotNull(message = "Vehicle type plate cannot be null")
    private VehicleType vehicleType;

    public Timestamp getExitTime() {
        return exitTime;
    }

    public void setExitTime(Timestamp exitTime) {
        this.exitTime = exitTime;
    }

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
        return Objects.equals(numberPlate, that.numberPlate) && Objects.equals(entryTime, that.entryTime) && Objects.equals(exitTime, that.exitTime) && vehicleType == that.vehicleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberPlate, entryTime, exitTime, vehicleType);
    }

    @Override
    public String toString() {
        return "VehicleDetailsDTO{" +
                "numberPlate='" + numberPlate + '\'' +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
