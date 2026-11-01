package com.starter.demo.lld.modals;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="PARKING_FLOOR")
public class ParkingFloor {
    @Id
    private String floorNumber;
    @OneToMany
    private List<ParkingFloor> parkingFloors;

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
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
        ParkingFloor that = (ParkingFloor) o;
        return Objects.equals(floorNumber, that.floorNumber) && Objects.equals(parkingFloors, that.parkingFloors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorNumber, parkingFloors);
    }

    @Override
    public String toString() {
        return "ParkingFloor{" +
                "floorNumber='" + floorNumber + '\'' +
                ", parkingFloors=" + parkingFloors +
                '}';
    }
}
