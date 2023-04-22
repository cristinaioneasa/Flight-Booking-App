package com.example.demo.Service;

import com.example.demo.entity.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TicketService {

    Ticket findByNoTicket(Long number);
    List<Ticket> findByPassagerName(String passagerName);
    boolean deleteTicket(Long noTicket);
    Ticket modifyPrice(Ticket ticket, int price);
    Ticket insertTicket(Ticket ticket);
}
