import {Component, OnInit} from '@angular/core';
import {UserService} from "../../service/User.service";
import {User} from "../../model/User";
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();


  constructor(private userService:UserService,
              private router: Router) { }

  ngOnInit(): void {
  }

  loginUser() {
    this.userService.loginUser(this.user).subscribe(data=>{
      alert("User login successfully");
      this.router.navigateByUrl('/client');
    },error => {
      alert("Login failed");
    })
  }

  loginAdmin() {
    this.userService.loginAdmin(this.user).subscribe(data=>{
      alert("Admin login successfully");
      this.router.navigateByUrl('/admin');
    },error => {
      alert("Login failed");
    })
  }

}
