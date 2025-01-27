package repository;

import models.Vehicle;

import java.util.Optional;

public interface IVehicleRepository {
    public Optional<Vehicle> findByVehicleNumber(String vehicleNUmber);
    public Vehicle save(Vehicle vehicle);
}
