package repository.impl;

import models.Vehicle;
import repository.IVehicleRepository;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository implements IVehicleRepository {

    private final Map<Long, Vehicle> vehicleMap =  new TreeMap<>();

    private long lastSavedId = 0L;


    public Optional<Vehicle> findByVehicleNumber( String vehicleNUmber){

        for(Vehicle vehicle: vehicleMap.values()){
            if(vehicle.getVehicleNumber().equals(vehicleNUmber)){
                return Optional.of(vehicle);
            }
        }

        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle){
        vehicle.setId(lastSavedId+1);
        lastSavedId++;
        vehicleMap.put(lastSavedId,vehicle);

        return vehicle;
    }


}
