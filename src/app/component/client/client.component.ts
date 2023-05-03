import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Flight} from "../../model/Flight";
import {FlightService} from "../../service/Flight.service";
import {Ticket} from "../../model/Ticket";
import {TicketService} from "../../service/Ticket.service";
import {User} from "../../model/User";
import {UserService} from "../../service/User.service";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  flightList: Flight[] = [];
  ownerList: any;
  updateForm: FormGroup | undefined;
  flight: Flight = new Flight();
  ticket: Ticket = new Ticket();
  user: User = new User();
  userInfo: String = this.userService.userInfo;

  constructor(private flightService: FlightService,
              private ticketService: TicketService,
              private userService: UserService,
              private formBuilder:FormBuilder,) { }

  ngOnInit(): void {
    this.flightService.findAll().subscribe((res)=>{
      console.log(res);
      this.flightList = res;
    },
      (_error)=>{
      });

    this.initOwnerFlightsForm();
  }

  findByArrival(arrival: any){
    this.flightService.findByArrival(arrival).subscribe((res)=>{
        console.log(res);
        this.flightList = res;
      },
      (_error)=>{
      });
  }

  findByDeparture(departure: any){
    this.flightService.findByDeparture(departure).subscribe((res)=>{
      console.log(res);
      this.flightList = res;
    },
      (_error)=>{
    });
  }

  sortByPrice(){
    this.flightService.sortByPrice().subscribe((res)=>{
        console.log(res);
        this.flightList = res;
      },
      (_error)=>{
      });
  }

  initOwnerFlightsForm(){
    this.updateForm=this.formBuilder.group({
      ownerInput:[null, Validators.required],
      flightInput:[null, Validators.required]
    })
  }

  insertTicket(number:any, seat:any){
    this.ticketService.insertUser(number, this.userService.userEmail, seat).subscribe(data=>{
      alert("Rezerve successfully");
    }, error => {alert("Rezerve failed");
    })
  }

  logout(){
    this.userService.logout(this.userService.userEmail).subscribe(data => {
      alert("Logout succesfully");
    },error => {alert("failed");
    })
  }
}
