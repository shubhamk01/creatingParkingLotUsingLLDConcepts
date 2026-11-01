package com.starter.demo.lld.services;

import com.starter.demo.lld.dto.TicketDTO;
import com.starter.demo.lld.dto.VehicleDetailsDTO;
import org.springframework.stereotype.Service;

@Service
public class ParkingSystemService {

    public TicketDTO getParkingSpotAndTicket(VehicleDetailsDTO vehicleDetailsDTO) {
        TicketDTO ticketDTO = new TicketDTO();

        return ticketDTO;
    }
}
