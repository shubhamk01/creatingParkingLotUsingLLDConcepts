package com.starter.demo.lld.common.custom.exceptions;

public class ParkingSlotNotAvailable extends RuntimeException {
    public ParkingSlotNotAvailable(String message) {
        super(message);
    }
}
