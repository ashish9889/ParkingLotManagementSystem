package controllers;

import models.*;

import java.time.LocalDateTime;
import java.util.Date;

public class TicketController {
    public void issueTicket(ParkingLot parkingLot, Gate gate, Vehicle vehicle, Operator operator) {
        Ticket ticket = new Ticket();
        ticket.setIssuedAt(gate);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date(System.currentTimeMillis()));
        ticket.setIssuedBy(operator);
    }

    //createTicket
    //getTicket
    //updateTicket
    //deleteTicket
}
