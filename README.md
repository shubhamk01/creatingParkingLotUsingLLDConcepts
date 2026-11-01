# creatingParkingLotUsingLLDConcepts
This repo is to learn LLD concepts using Parking Lot

## Problem Statement

Design a parking lot with `n` floors that can accommodate 3 types of vehicles: `bike`, `car`, `truck`.

- When a vehicle enters through the entry gate, a parking ticket is generated and an available parking spot is assigned to it according to the vehicle type.
- When a vehicle exits through the exit gate, the parking fee is calculated based on the entry time.
- The design should allow adding a new vehicle type in the future with minimal changes.

## Entities

`Vehicle`, `Ticket`, `ParkingLot`, `ParkingFloor`, `ParkingSpot`

### VehicleType
```
VehicleType {
    car, truck, bike
}
```

### FareCalculationStrategy
```
FareCalculationStrategy {
    calculate(amount, ticket)
}
```

### Vehicle
```
Vehicle {
    string numberPlate;
    enum vehicleType;
}
```

### Ticket
```
Ticket {
    string ticketId;
    date startTime;
    date endTime;
    class vehicle;
    class parkingSpot;
    double amount;
}
```
`Ticket` has a `Vehicle` and a `ParkingSpot`.

### ParkingSpot
```
ParkingSpot {
    string spotId;
    enum vehicleType;
    boolean isAvailable;
}
```

### ParkingFloor
```
ParkingFloor {
    long floorNumber;
    List<ParkingSpot> parkingSpots;
}
```

### ParkingLot
```
ParkingLot {
    List<ParkingFloor> parkingFloors;

    findSlots(type);
    entry(vehicle, spot);
    exit(ticket);
}
```
