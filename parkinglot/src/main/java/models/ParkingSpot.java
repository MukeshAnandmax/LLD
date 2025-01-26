package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class ParkingSpot extends BaseModel{
    private int spotNumber;
    private List<VehicleType> AllowedVehicleTypeList;
    private SpotStatus spotStatus;
    private Vehicle vehicle;

}
