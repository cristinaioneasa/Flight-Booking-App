import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Flight} from "../../model/Flight";
import {FlightService} from "../../service/Flight.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  flight: Flight = new Flight();

  constructor(private flightService: FlightService,
              private formBuilder:FormBuilder,) { }

  ngOnInit(): void {
  }

  insertFlight(){
    this.flightService.insertFlight(this.flight).subscribe(data=>{
      alert("Flight created successfully");
    }, error => {alert("Insert failed");
    })
  }

}
