package com.starter.demo.lld.common.custom.exceptions;

public class WrongVehicleTypeException extends RuntimeException {
    public WrongVehicleTypeException(String message) {
        super(message);
    }
}
