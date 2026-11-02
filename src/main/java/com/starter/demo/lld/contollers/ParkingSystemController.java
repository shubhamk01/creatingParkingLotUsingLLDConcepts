package com.starter.demo.lld.contollers;

import com.starter.demo.lld.dto.TicketDTO;
import com.starter.demo.lld.dto.VehicleDetailsDTO;
import com.starter.demo.lld.services.ParkingSystemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/parking-lot-entry")
public class ParkingSystemController {

    @Autowired
    private ParkingSystemService parkingSystemService;

    @PostMapping(path = "/get-parking-spot-and-ticket")
    public TicketDTO getParkingSpotAndTicket(@Valid @RequestBody VehicleDetailsDTO vehicleDetailsDTO) {
        return parkingSystemService.getParkingSpotAndTicket(vehicleDetailsDTO);
    }

    @GetMapping(path = "/get-amount-for-parking")
    public TicketDTO getParkingAmount(@Valid @RequestBody VehicleDetailsDTO vehicleDetailsDTO) {
        return parkingSystemService.getParkingSpotAndTicket(vehicleDetailsDTO);
    }
}
