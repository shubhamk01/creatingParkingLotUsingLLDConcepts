package com.starter.demo.lld.services;

import com.starter.demo.lld.dto.TicketDTO;
import com.starter.demo.lld.dto.VehicleDetailsDTO;
import com.starter.demo.lld.modals.Ticket;
import com.starter.demo.lld.modals.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSystemService {

    @Autowired
    private VehicleFareStrategy vehicleFareStrategy;

    public TicketDTO getParkingSpotAndTicket(VehicleDetailsDTO vehicleDetailsDTO) {
        return getTicket(vehicleDetailsDTO);
    }

    private TicketDTO getTicket(VehicleDetailsDTO vehicleDetailsDTO) {
        Ticket ticket = getTicketFromVehicleDTO(vehicleDetailsDTO);
        return getTicketDTOFromTicket(ticket);
    }

    private TicketDTO getTicketDTOFromTicket(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setTicketId(ticket.getTicketId());
        ticketDTO.setEntryTime(ticket.getTicketEntryDateTime());
        ticketDTO.setVehicleNumberPlate(ticket.getVehicle().getNumberPlate());
        ticketDTO.setVehicleType(ticket.getVehicle().getVehicleType());
        ticketDTO.setAmount(ticket.getAmount());
        ticketDTO.setExitTime(ticket.getTicketExitDateTime());
        return ticketDTO;
    }

    private Ticket getTicketFromVehicleDTO(VehicleDetailsDTO vehicleDetailsDTO) {
        Ticket ticket = new Ticket();
        Vehicle vehicle = getVehicleFromVehicleDTO(vehicleDetailsDTO);

        ticket.setTicketEntryDateTime(vehicleDetailsDTO.getEntryTime());
        ticket.setVehicle(vehicle);
        ticket.setTicketExitDateTime(vehicleDetailsDTO.getExitTime());
        ticket.setAmount(vehicleFareStrategy.getAmountFromStrategy(vehicleDetailsDTO.getVehicleType(), vehicleDetailsDTO.getEntryTime(), vehicleDetailsDTO.getExitTime()));

        return ticket;
    }

    private Vehicle getVehicleFromVehicleDTO (VehicleDetailsDTO vehicleDetailsDTO) {
        Vehicle vehicle = new Vehicle();

        vehicle.setNumberPlate(vehicleDetailsDTO.getNumberPlate());
        vehicle.setVehicleType(vehicleDetailsDTO.getVehicleType());

        return vehicle;
    }


}
