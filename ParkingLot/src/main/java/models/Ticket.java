package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Ticket extends BaseModel{
    private int number;
    private ParkingSlot parkingSlot;
    private Vehicle vehicle;
    private Gate issuedAt;
    private Operator issuedBy;
    private Date entryTime;

}
