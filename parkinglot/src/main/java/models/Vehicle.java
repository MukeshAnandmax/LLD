package models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Vehicle extends BaseModel{
    private String vehicleNumber;
    private VehicleType vehicleType;
}
