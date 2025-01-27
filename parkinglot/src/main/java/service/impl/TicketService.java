package service.impl;

import exception.GateNotFoundException;
import exception.ParkingLotNotFoundException;
import exception.SpotNotFoundException;
import models.*;
import repository.IGateRepository;
import repository.IParkingLotRepository;
import repository.ITicketRepository;
import repository.IVehicleRepository;
import repository.impl.GateRepository;
import repository.impl.TicketRepository;
import repository.impl.VehicleRepository;
import service.ITicketService;
import service.IVehicalService;
import strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.time.LocalDateTime;
import java.util.Optional;

public class TicketService implements ITicketService {

    private final  SpotAssignmentStrategy spotAssignmentStrategy;
    private final IGateRepository gateRepository;
    private final IVehicleRepository vehicleRepository;
    private  final IVehicalService vehicleService;
    private final ITicketRepository ticketRepository;
    private final IParkingLotRepository parkingLotRepository;

    public TicketService(SpotAssignmentStrategy spotAssignmentStrategy, IGateRepository gateRepository, IVehicleRepository vehicleRepository, IVehicalService vehicleService, ITicketRepository ticketRepository, IParkingLotRepository parkingLotRepository) {
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.vehicleService = vehicleService;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public Ticket generateTicket(long gateID, VehicleType vehicleType, String vehicleNumber) {


        Optional<Gate> byGateId = gateRepository.findByGateId(gateID);

        if(byGateId.isEmpty()){
            throw new GateNotFoundException("Gate number is wrong");
        }
        Gate gate = byGateId.get();
        Operator operator = gate.getOperator();

        Optional<Vehicle> byVehicleNumber = vehicleRepository.findByVehicleNumber(vehicleNumber);

        Vehicle vehicle= byVehicleNumber.orElseGet(
                () -> vehicleService.createVehicle(vehicleNumber, vehicleType)
        );

        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotByGate(gate);

        if(parkingLotOptional.isEmpty()){

            throw  new ParkingLotNotFoundException();
        }
        ParkingLot parkingLot = parkingLotOptional.get();



        Optional<ParkingSpot> spotOptional = spotAssignmentStrategy.findSpot(vehicleType, parkingLot, gate);

        if(spotOptional.isEmpty()){
            throw new SpotNotFoundException("Sorry, No parking spot is available for your vehicle");
        }
        ParkingSpot spot = spotOptional.get();


        Ticket ticket =  new Ticket();
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setParkingSpot(spot);
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setOperator(operator);


        return ticketRepository.save(ticket);
    }
}
