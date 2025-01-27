package repository.impl;

import models.Gate;
import models.ParkingLot;
import models.ParkingSpot;
import repository.IParkingLotRepository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository implements IParkingLotRepository {

    private final Map<Long, ParkingLot> parkingLotMap =  new TreeMap<>();


    @Override
    public Optional<ParkingLot> getParkingLotByGate(Gate gate) {

        for(ParkingLot parkingLot: parkingLotMap.values()){
            for(Gate gate1: parkingLot.getGates()){
                if(gate1.getId()== gate.getId()){
                    return Optional.of(parkingLot);
                }
            }
        }


        return Optional.empty();
    }
}
