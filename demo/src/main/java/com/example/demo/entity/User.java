package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 30)
    private String name;
    private String username;
    private String password;
    private User_type type;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fk_user_to_flight")
    private Flight flightToUser;
}
