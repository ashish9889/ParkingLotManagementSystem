package models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParkingSlot extends BaseModel{
    private String number;
    private ParkingSlotStatus  parkingSlotStatus;
    private VehicleType allowedVehicleType;

    public void parkVehicle(Vehicle vehicle) {
        setParkingSlotStatus(ParkingSlotStatus.UNAVAILABLE);
    }
}
