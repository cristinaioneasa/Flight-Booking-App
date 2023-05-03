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
    private String email;
    private String password;
    private User_type type;
    private boolean logged;

    @OneToMany(mappedBy= "userToTicket",cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Ticket> ticket=new ArrayList<>();

}
