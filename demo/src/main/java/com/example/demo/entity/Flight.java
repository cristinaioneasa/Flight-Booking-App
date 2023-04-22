package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private String departure;
    private String arrival;
    private LocalDateTime date_time;
    private LocalDateTime date_time_arrival;
    private int duration;
    private int nr_seats;

    @OneToMany(mappedBy= "flightToTicket",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ticket> ticket=new ArrayList<>();
}
