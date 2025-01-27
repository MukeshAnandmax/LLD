package service;

import models.Ticket;
import models.VehicleType;

public interface ITicketService {

    Ticket generateTicket(long gateID, VehicleType vehicleType,String vehicleNumber);
}
