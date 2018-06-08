import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-usernav',
  templateUrl: './usernav.component.html',
  styleUrls: ['./usernav.component.css']
})
export class UsernavComponent implements OnInit {
  public user: User = JSON.parse(sessionStorage.getItem("loggedUser"));

  constructor() { }

  ngOnInit() {
 
  }

}
