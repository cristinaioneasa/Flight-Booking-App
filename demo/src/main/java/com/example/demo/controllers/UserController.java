package com.example.demo.controllers;

import com.example.demo.Service.FlightService;
import com.example.demo.Service.FlightServiceImplementare;
import com.example.demo.Service.UserService;
import com.example.demo.controllers.DTO.UserDTO;
import com.example.demo.entity.Flight;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private FlightService flightService;

   @PutMapping("/updatePassword")
    public User updatePassword(@RequestBody UserDTO userDTO){
       return userService.updateUser(userDTO, userDTO.getPassword());
   }
   @PostMapping("/insertUser")
    public User insertUser(@RequestBody User user){
       return userService.insertUser(user);
   }

    @PutMapping("/insertUser")
    public User insertUser(@RequestBody User user, @RequestParam String number){
        Flight flight = flightService.findByNumber(number);
        user.setFlightToUser(flight);
        return userService.insertUser(user);
    }

}
