package com.starter.demo.lld.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Ticket {

    @Id
    private String ticketId;
    private Timestamp ticketEntryDateTime;
    private Timestamp ticketExitDateTime;
    private Vehicle vehicle;
    private ParkingLot parkingLot;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Timestamp getTicketEntryDateTime() {
        return ticketEntryDateTime;
    }

    public void setTicketEntryDateTime(Timestamp ticketEntryDateTime) {
        this.ticketEntryDateTime = ticketEntryDateTime;
    }

    public Timestamp getTicketExitDateTime() {
        return ticketExitDateTime;
    }

    public void setTicketExitDateTime(Timestamp ticketExitDateTime) {
        this.ticketExitDateTime = ticketExitDateTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ticketId, ticket.ticketId) && Objects.equals(ticketEntryDateTime, ticket.ticketEntryDateTime) && Objects.equals(ticketExitDateTime, ticket.ticketExitDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, ticketEntryDateTime, ticketExitDateTime);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", ticketEntryDate=" + ticketEntryDateTime +
                ", ticketExitDate=" + ticketExitDateTime +
                ", vehicle=" + vehicle +
                ", parkingLot=" + parkingLot +
                '}';
    }
}
