package dto;

import lombok.Getter;
import lombok.Setter;
import models.VehicleType;

@Getter@Setter
public class GenerateTicketRequestDto {
    private String vehicleNumber ;
    private VehicleType vehicleType;
    private long gateID;
}
