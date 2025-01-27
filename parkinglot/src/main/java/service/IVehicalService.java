package service;

import models.Vehicle;
import models.VehicleType;

public interface IVehicalService {

    Vehicle createVehicle(String vehicleNumber, VehicleType vehicleType);
}
