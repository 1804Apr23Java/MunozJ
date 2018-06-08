import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  public user: User = JSON.parse(sessionStorage.getItem("loggedUser"));
  constructor(private _router:Router) { }

  ngOnInit() {
    if(this.user==null){
      console.log("null username");
      this._router.navigate(["/login"]);
    }else{
      console.log(this.user.username);
    }
  }

}
