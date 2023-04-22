package com.example.demo.controllers;

import com.example.demo.Service.FlightService;
import com.example.demo.Service.TicketService;
import com.example.demo.entity.Flight;
import com.example.demo.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightService flightService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @DeleteMapping("/deleteTicket")
    public boolean deleteTicket(@RequestParam Long noTicket) {
        return ticketService.deleteTicket(noTicket);
    }

    @PutMapping("/updatePrice")
    public Ticket updatePrice(@RequestBody Ticket ticket) {
        return ticketService.modifyPrice(ticket, ticket.getPrice());
    }

    @PutMapping("/insertTicket")
    public Ticket insertTicket(@RequestBody Ticket ticket, @RequestParam String number){
        Flight flight = flightService.findByNumber(number);
        ticket.setFlightToTicket(flight);
        return ticketService.insertTicket(ticket);
    }
}
