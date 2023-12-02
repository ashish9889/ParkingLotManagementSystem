package models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParkVehicleDTO {
    private Vehicle vehicle;
    private Gate gateEnteringAt;
    private Operator operator;
    private ParkingLot parkingLot;
}
