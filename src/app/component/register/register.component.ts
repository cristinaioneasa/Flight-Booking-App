import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router, ActivatedRoute} from "@angular/router";
import {UserService} from "../../service/User.service";
import {User} from "../../model/User";

@Component({
  selector: 'app-register',
  templateUrl: 'register.component.html',
  styleUrls: ['register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();

  constructor(private userService:UserService,
              private formBuilder:FormBuilder,
              private router: Router,
              private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
  }

  createUser() {
    this.userService.insertUser(this.user).subscribe(data=>{
      alert("User created successfully");
    },error => {
      alert("User failed");
    })
  }

}
