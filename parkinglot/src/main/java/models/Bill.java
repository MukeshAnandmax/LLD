package models;

import java.time.LocalDateTime;

public class Bill extends BaseModel{

    private LocalDateTime exitTime;
    private Ticket ticket;
    private Operator operator;
     private  int amount;
    private Gate gate;

}
