package com.starter.demo.lld.dto;

import com.starter.demo.lld.common.enums.VehicleType;
import com.starter.demo.lld.modals.ParkingLot;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public class TicketDTO {
    @NotNull(message = "Ticket number cannot be null")
    @NotEmpty(message = "Ticket number plate cannot be empty")
    private String ticketId;

    @NotNull(message = "Vehicle number plate cannot be null")
    @NotEmpty(message = "Vehicle number plate cannot be empty")
    private String vehicleNumberPlate;

    @NotNull(message = "Vehicle Type cannot be null")
    @NotEmpty(message = "Vehicle Type cannot be empty")
    private VehicleType vehicleType;

    @NotNull(message = "Vehicle entry time cannot be null")
    @NotEmpty(message = "Vehicle entry time cannot be empty")
    private Timestamp entryTime;

    @NotNull(message = "Vehicle exit time cannot be null")
    @NotEmpty(message = "Vehicle exit time cannot be empty")
    private Timestamp exitTime;

    private ParkingLot parkingLot;

    private double amount;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getVehicleNumberPlate() {
        return vehicleNumberPlate;
    }

    public void setVehicleNumberPlate(String vehicleNumberPlate) {
        this.vehicleNumberPlate = vehicleNumberPlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    public Timestamp getExitTime() {
        return exitTime;
    }

    public void setExitTime(Timestamp exitTime) {
        this.exitTime = exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicleNumberPlate='" + vehicleNumberPlate + '\'' +
                ", vehicleType=" + vehicleType +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", amount=" + amount +
                '}';
    }
}
