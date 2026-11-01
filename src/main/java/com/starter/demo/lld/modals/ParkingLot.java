package com.starter.demo.lld.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PARKING_LOT")
public class ParkingLot {
    @Id
    private String id;
    @OneToMany
    private List<ParkingFloor> parkingFloors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return Objects.equals(id, that.id) && Objects.equals(parkingFloors, that.parkingFloors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parkingFloors);
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id='" + id + '\'' +
                ", parkingFloors=" + parkingFloors +
                '}';
    }

    public int[] getParkingSpot(){
        return null;
    }
}
