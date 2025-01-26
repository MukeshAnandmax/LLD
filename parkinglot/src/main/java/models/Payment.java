package models;

import java.time.LocalDateTime;

public class Payment extends BaseModel{
    private  PaymentMode paymentMode;
    private int amount;
    private PaymentStatus paymentStatus;
    private String refId;
    private Bill bill;
    private LocalDateTime time;
}
