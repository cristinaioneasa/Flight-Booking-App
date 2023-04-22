package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long noTicket;
    public String passagerName;
   // public String numberFlight;
    public String seat;
    public int price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fk_ticket_to_flight")
    private Flight flightToTicket;
}
