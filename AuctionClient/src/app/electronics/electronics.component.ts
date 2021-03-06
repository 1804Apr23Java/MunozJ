import { Component, OnInit } from '@angular/core';
import { ItemService } from '../sharedservice/item.service';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';
import { Item } from '../models/item';
import { User } from '../user';
import { ClientMessage } from '../models/client-message';

@Component({
  selector: 'app-electronics',
  templateUrl: './electronics.component.html',
  styleUrls: ['./electronics.component.css']
})
export class ElectronicsComponent implements OnInit {
  public item1: Item = new Item ('', '', 0 , '','',0,0);
  public item2: Item = JSON.parse(sessionStorage.getItem("asd"));
  public currentItem: number;
   
  public item3 =Array<Item>();
  //public currentTime : Date;
  public clientMsg: ClientMessage = new ClientMessage("");
  constructor(private _itemService: ItemService, private _router: Router) { 
   
  }
  ngOnInit(){

  }
  public goToItem(): void{
    
  }
  public getCategoryTag(): void {
    this._itemService.getItemByCategory(this.item1).subscribe(
      data => {
       console.log(data);
       this.item3=<Item[]>data;
       
      },
      error => {
        console.log("Error");
      }

    )


  }
  public itemBid(): void {
    this._itemService.bidItem(this.item1.itemName, this.item1.itemName).subscribe(
      data => {
       console.log(data);
       this.item1=<Item>data;
       
      },
      error => {
        console.log("Error");
      }

    )


  }
}

