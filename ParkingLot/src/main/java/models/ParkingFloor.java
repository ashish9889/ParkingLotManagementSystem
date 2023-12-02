package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class ParkingFloor extends BaseModel{
    private int number;
    private List<ParkingSlot> parkingSlots;
    private ParkingFloorStatus parkingFloorStatus;
}
