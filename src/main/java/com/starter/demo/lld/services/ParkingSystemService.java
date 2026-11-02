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

    private Ticket ticket;

    private Vehicle vehicle;

    private TicketDTO ticketDTO;

    private VehicleDetailsDTO vehicleDetailsDTO;

    public TicketDTO getParkingSpotAndTicket(VehicleDetailsDTO vehicleDetailsDTO) {
        this.vehicleDetailsDTO = vehicleDetailsDTO;
        this.getVehicleFromVehicleDTO();
        this.getTicketFromVehicleDTO();
        this.getAvailableParkingLot();
        this.getTicketDTOFromTicket();
        if (vehicleDetailsDTO.getExitTime() == null) {
            this.addInRepos();
        }else{
            this.updateInRepos();
        }
        return this.ticketDTO;
    }

    private void updateInRepos() {

    }

    private void addInRepos() {
    }

    private void getTicketDTOFromTicket() {
        this.ticketDTO.setTicketId(this.ticket.getTicketId());
        this.ticketDTO.setEntryTime(this.ticket.getTicketEntryDateTime());
        this.ticketDTO.setVehicleNumberPlate(this.ticket.getVehicle().getNumberPlate());
        this.ticketDTO.setVehicleType(this.ticket.getVehicle().getVehicleType());
        this.ticketDTO.setAmount(this.ticket.getAmount());
        this.ticketDTO.setExitTime(this.ticket.getTicketExitDateTime());
    }

    private void getTicketFromVehicleDTO() {
        this.ticket.setTicketEntryDateTime(this.vehicleDetailsDTO.getEntryTime());
        this.ticket.setVehicle(this.vehicle);
        this.ticket.setTicketExitDateTime(this.vehicleDetailsDTO.getExitTime());
        this.ticket.setAmount(this.vehicleFareStrategy.getAmountFromStrategy(this.vehicleDetailsDTO.getVehicleType(), vehicleDetailsDTO.getEntryTime(), vehicleDetailsDTO.getExitTime()));

    }

    private void getVehicleFromVehicleDTO () {
        this.vehicle.setNumberPlate(this.vehicleDetailsDTO.getNumberPlate());
        this.vehicle.setVehicleType(this.vehicleDetailsDTO.getVehicleType());
    }

    private void getAvailableParkingLot(){
        
    }

}
