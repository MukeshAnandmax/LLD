package service.impl;

import models.Vehicle;
import models.VehicleType;
import repository.IGateRepository;
import repository.IVehicleRepository;
import repository.impl.VehicleRepository;
import service.IVehicalService;

public class VehicleService implements IVehicalService {

    private final IVehicleRepository vehicleRepository;

    public VehicleService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(String vehicleNumber, VehicleType vehicleType) {
        Vehicle vehicle =  new Vehicle();
        vehicle.setVehicleNumber(vehicleNumber);
        vehicle.setVehicleType(vehicleType);
        vehicle = vehicleRepository.save(vehicle);
        return vehicle;
    }
}
