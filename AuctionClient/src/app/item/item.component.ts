import { Component, OnInit } from '@angular/core';
import { ItemService } from '../sharedservice/item.service';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';
import { Item } from '../models/item';
import { User } from '../user';
import { ClientMessage } from '../models/client-message';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
 
  //  ///add/{itemName}/{description}/{currentPrice}/{categoryTag}/{image}/{timeLeft}
  public user: User = JSON.parse(sessionStorage.getItem("loggedUser"));
  public item: Item = new Item ('', '', 0 , '','',0,0);
  public currentTime : Date;
  public clientMsg: ClientMessage = new ClientMessage("");
  constructor(private _itemService: ItemService, private _router: Router) { 
   
  }
public sellitem():void {
  if (sessionStorage.getItem("loggedUser")==="{}"){
    this._router.navigate(["/login"]);
  }else{
    this._itemService.addItem(this.item).subscribe(
      data => this.clientMsg = data, 
      error => this.clientMsg.message="item wasnt added");
  }


}
  ngOnInit() {
    if(this.user==null){
      console.log("null username");
      this._router.navigate(["/login"]);
    }else{
      console.log(this.user.username);
    }
  }

}
