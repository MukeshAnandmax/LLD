package controller;

import dto.GenerateTicketRequestDto;
import dto.GenerateTicketResponseDto;
import dto.ResponseStatus;
import models.Ticket;
import models.VehicleType;
import service.ITicketService;

public class TicketController {

    private final ITicketService ticketService;

    public TicketController(ITicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto ticketRequestDto){
        GenerateTicketResponseDto ticketResponseDto = new GenerateTicketResponseDto();

        String vehicleNumber = ticketRequestDto.getVehicleNumber();
        VehicleType vehicleType =ticketRequestDto.getVehicleType();
        long gateID= ticketRequestDto.getGateID();

        Ticket ticket = ticketService.generateTicket(gateID, vehicleType, vehicleNumber);

        ticketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        ticketResponseDto.setTicketId(ticket.getId());
        ticketResponseDto.setOperatorName(ticket.getOperator().getName());
        ticketResponseDto.setSpotNumber(ticket.getParkingSpot().getSpotNumber());


        return ticketResponseDto;
    }
}
