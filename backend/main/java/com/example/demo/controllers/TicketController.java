package com.example.demo.controllers;

import com.example.demo.Service.FlightService;
import com.example.demo.Service.TicketService;
import com.example.demo.Service.UserService;
import com.example.demo.controllers.DTO.FlightDTO;
import com.example.demo.controllers.DTO.UserDTO;
import com.example.demo.controllers.mapper.FlightMapper;
import com.example.demo.controllers.mapper.UserMapper;
import com.example.demo.entity.Flight;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private UserService userService;

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
    public Ticket insertTicket(@RequestParam String number, @RequestParam String email, @RequestParam String seat){
        FlightDTO flight = flightService.findByNumber(number);
        UserDTO user = userService.findByEmail(email);
        System.out.println(user.getName());
        Ticket ticket = new Ticket();
        ticket.setSeat(seat);
        ticket.setPrice(flight.getPrice());
        ticket.setPassagerName(user.getName());
        ticket.setFlightToTicket(FlightMapper.mapDTOToModel(flight));
        ticket.setUserToTicket(UserMapper.mapDTOToModel(user));
        return ticketService.insertTicket(ticket);
    }
}
