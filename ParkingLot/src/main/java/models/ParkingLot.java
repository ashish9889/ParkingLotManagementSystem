package models;

import lombok.Getter;
import lombok.Setter;
import strategies.SlotAllocationStrategy;

import java.util.List;

@Getter
@Setter
public class ParkingLot extends BaseModel{

    private String name;
    private List<ParkingFloor> parkingFloors;
    private List<VehicleType> allowedVehicleTypes;
    private ParkingLotStatus parkingLotStatus;
    private List<Gate> gates;
    private List<BillingStrategy> billingStrategies;
    private List<SlotAllocationStrategy> slotAllocationStrategies;

}
