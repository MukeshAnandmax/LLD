package repository;

import models.Gate;
import models.ParkingLot;

import java.util.Optional;

public interface IParkingLotRepository {

    public Optional<ParkingLot> getParkingLotByGate(Gate gate);
}
