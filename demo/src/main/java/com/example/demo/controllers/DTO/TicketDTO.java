package com.example.demo.controllers.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TicketDTO {

    public Long noTicket;
    public String passagerName;
    public String numberFlight;
    public String seat;
    public int price;
}
