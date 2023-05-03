import {Component, OnInit} from '@angular/core';
import {UserService} from "../../service/User.service";
import {User} from "../../model/User";
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './password.component.html',
  styleUrls: ['./password.component.css']
})
export class PasswordComponent implements OnInit {

  user: User = new User();
  old_password: any;


  constructor(private userService:UserService,
              private router: Router) { }

  ngOnInit(): void {
  }

  sendEmail(email: any){
    this.userService.send_password(email).subscribe()
  }

  updatePassword(email:any, old_password: any, new_password: any) {
    this.userService.update_password(email, old_password, new_password);
  }

}
