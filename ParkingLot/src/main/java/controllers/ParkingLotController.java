package controllers;


import exceptions.ParkingLotFullException;
import exceptions.ParkingSlotUnavailableException;
import models.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParkingLotController {
    private ParkingLot parkingLot;
    private TicketController ticketController;

    //AddFloor
    //RemoveFloor
    //AddAllowedVehicleType
    //RemoveAllowedVehicleType
    //AddGate
    //UpdateGate
    private boolean checkAvailabilityForVehicleType(VehicleType vehicleType){
        return false;
    }
    //getAvailability
    private ParkingSlot getNextAvailableSlot(ParkingLot parkingLot, VehicleType vehicleType) throws ParkingLotFullException {
        ParkingSlot availableParkingSlot = parkingLot.getSlotAllocationStrategies().get(0).getSlot(vehicleType);
        if(availableParkingSlot != null){
            return availableParkingSlot;
        }
        throw new ParkingLotFullException();
    }
    public void parkVehicle(ParkVehicleDTO parkVehicleDTO) throws ParkingLotFullException {

        if(checkAvailabilityForVehicleType(parkVehicleDTO.getVehicle().getType())){
            ParkingSlot availableSlot = this.getNextAvailableSlot(parkingLot, parkVehicleDTO.getVehicle().getType());
            availableSlot.parkVehicle(parkVehicleDTO.getVehicle());
            this.ticketController.issueTicket(parkVehicleDTO.getParkingLot(),parkVehicleDTO.getGateEnteringAt(),
                    parkVehicleDTO.getVehicle(), parkVehicleDTO.getOperator());
        }
    }
    //AddBookingStrategy
    //RemoveBookingStrategy
    //AddSlotAllocationStrategy
    //removeSlotAllocationStrategy
    //API to get list of available slots for each vehicle type
    public static List<ParkingSlot> getAvailableSlotsForVehicleType(ParkingLot parkingLot, VehicleType vehicleType){
        List<ParkingSlot> availableParkingSlots = new ArrayList<>();
        parkingLot.getParkingFloors().stream().forEach(pf -> pf.getParkingSlots().stream().filter(ps -> ps.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)).forEach(availableParkingSlots::add));

        return availableParkingSlots;
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingFloor> parkingFloors = new ArrayList<>();

        ParkingFloor parkingFloor = new ParkingFloor();
        List<ParkingSlot> parkingSlots = new ArrayList<>();

        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setNumber("1");
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
        parkingSlot.setAllowedVehicleType(VehicleType.BUS);


        ParkingSlot parkingSlot2 = new ParkingSlot();
        parkingSlot2.setNumber("2");
        parkingSlot2.setParkingSlotStatus(ParkingSlotStatus.UNAVAILABLE);
        parkingSlot2.setAllowedVehicleType(VehicleType.BUS);

        parkingSlots.add(parkingSlot);
        parkingSlots.add(parkingSlot2);
        parkingFloor.setParkingSlots(parkingSlots);

        parkingFloors.add(parkingFloor);

        ParkingFloor parkingFloor2 = new ParkingFloor();
        List<ParkingSlot> parkingSlots2 = new ArrayList<>();

        ParkingSlot parkingSlot21 = new ParkingSlot();
        parkingSlot21.setNumber("11");
        parkingSlot21.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
        parkingSlot21.setAllowedVehicleType(VehicleType.BUS);

        ParkingSlot parkingSlot22 = new ParkingSlot();
        parkingSlot22.setNumber("22");
        parkingSlot22.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
        parkingSlot22.setAllowedVehicleType(VehicleType.BUS);

        parkingSlots2.add(parkingSlot21);
        parkingSlots2.add(parkingSlot22);

        parkingFloor2.setParkingSlots(parkingSlots2);
        parkingFloors.add(parkingFloor2);

        parkingLot.setParkingFloors(parkingFloors);

        List<ParkingSlot> availableSlots = getAvailableSlotsForVehicleType(parkingLot, VehicleType.BUS);
        Map<String, Integer> data =new HashMap<>();
        data.put("A", 1);
        data.put("B", 2);
        data.put("C", 3);
    parkingSlot.getClass().getClassLoader()
        List<Integer> values = Arrays.asList("A","B","C").stream().map(a -> data.get(a)).collect(Collectors.toList());
        System.out.println(values);


    }

}
