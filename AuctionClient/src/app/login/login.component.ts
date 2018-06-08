import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserserviceService } from '../sharedservice/userservice.service';
import { ClientMessage } from '../models/client-message';
import {Router} from '@angular/router';
import { RouterModule, Routes } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public user: User = new User(0, '', '', '', '', '', 0, 0, 0, 0, '', '', '', '');
  public userdata: User = new User(0, '', '', '', '', '', 0, 0, 0, 0, '', '', '', '');
 
  public clientMessage: ClientMessage = new ClientMessage("")
  constructor(private userservice: UserserviceService, private _router:Router) { }

  ngOnInit() {

    console.log(this.user.username);
    console.log(this.user.password);
  }

  public login(): void {
    this.userservice.getUser(this.user).subscribe(
      data => {
        if (data.hasOwnProperty("username")) {
          this.user = <User>data;
          sessionStorage.setItem("loggedUser", JSON.stringify(this.user));
        
          this.clientMessage.message="Login Sucess";
           this._router.navigate(["/profile"]);
          
          console.log(data);
          
        }
      },
      error => {
        console.log("Error");
      }

    )


  }

}
