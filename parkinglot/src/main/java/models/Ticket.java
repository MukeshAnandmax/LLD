package models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Ticket extends BaseModel{
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private Gate gate;
    private Operator operator;

}
