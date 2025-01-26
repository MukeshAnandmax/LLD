package models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Gate extends BaseModel{
    private int gateNumber;
    private Operator operator;
    private GateStatus gaStatus;
    private GateType gateType;

}
