package models;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Gate extends BaseModel {
    private int number;
    private GateType gateType;
    private Operator currentOperator;
    private GateStatus gateStatus;
}
