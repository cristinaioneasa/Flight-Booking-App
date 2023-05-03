package com.example.demo.controllers;

import com.example.demo.Service.FlightService;
import com.example.demo.Service.UserService;
import com.example.demo.Service.emailServiceImplementare;
import com.example.demo.controllers.DTO.UserDTO;
import com.example.demo.controllers.mapper.FlightMapper;
import com.example.demo.entity.Flight;
import com.example.demo.entity.User;
import com.example.demo.entity.User_type;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private FlightService flightService;

    @Autowired
    private emailServiceImplementare emailSenderService;

   @PutMapping("/updatePassword")
    public User updatePassword(@RequestParam String email, @RequestParam String old_password, @RequestParam String new_password){
       return userService.updateUser(email, old_password, new_password);
   }

    @GetMapping("/findall")
    public List<UserDTO> findAllUsers() { return userService.findAllUsers();}

   @PostMapping("/insertUser")
    public User insertUser(@RequestBody User user){
       user.setType(User_type.CLIENT);
       return userService.insertUser(user);
   }

    @PutMapping("/insertUser")
    public User insertUser(@RequestBody User user, @RequestParam String number){
        Flight flight = FlightMapper.mapDTOToModel(flightService.findByNumber(number));
        //user.setFlightToUser(flight);
        return userService.insertUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody User user) {
        if( userService.loginUser(user.getEmail(), user.getPassword()) == null)
            return (ResponseEntity<UserDTO>) ResponseEntity.internalServerError();
        else return ResponseEntity.ok(userService.loginUser(user.getEmail(), user.getPassword()));
    }

    @PostMapping("/loginAdmin")
    public ResponseEntity<UserDTO> loginAdmin(@RequestBody User user) {
        if( userService.loginAdmin(user.getEmail(), user.getPassword()) == null)
            return (ResponseEntity<UserDTO>) ResponseEntity.internalServerError();
        else return ResponseEntity.ok(userService.loginAdmin(user.getEmail(), user.getPassword()));
    }

    @PostMapping("/logout")
    private ResponseEntity<UserDTO>logOut(@RequestParam String email) {
        return ResponseEntity.ok(userService.logOut(email));
    }

    @PostMapping("/send_password")
    public ResponseEntity<String> sendPassword(@RequestParam String email) throws MessagingException {
        emailSenderService.sendMailWithAttachment(email,
                "Your password is:" + userService.forgotPassword(email),
                "Password requested");
       return ResponseEntity.ok(userService.forgotPassword(email));
    }

    @GetMapping("/findByEmail")
    public UserDTO findByEmail(@RequestParam String email){
       return userService.findByEmail(email);
    }

    @GetMapping("/findByLogIn")
    public List<UserDTO> findByLogInOrNot(){
        return userService.findBylogInOrNot();
    }
}
