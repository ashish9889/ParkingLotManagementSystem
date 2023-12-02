package strategies;

import models.ParkingSlot;
import models.VehicleType;

public interface SlotAllocationStrategy {

    ParkingSlot getSlot(VehicleType vehicleType);
}
