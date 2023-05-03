package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data

public class Flight implements Comparable<Flight>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private String departure;
    private String arrival;
    private LocalDateTime date_time;
    private LocalDateTime date_time_arrival;
    private Float duration;
    private int nr_seats;
    private int price;

    @OneToMany(mappedBy= "flightToTicket",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ticket> ticket=new ArrayList<>();


    @Override
    public int compareTo(Flight o) {
        Integer price = this.getPrice();
        return price.compareTo(o.getPrice());
    }
}
