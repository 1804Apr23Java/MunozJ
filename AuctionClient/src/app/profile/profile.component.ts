import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';
import { ItemService } from '../sharedservice/item.service';
import { Item } from '../models/item';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  public item1: Item = new Item ('', '', 0 , '','',0,0);
  public item4: Item = new Item ('', '', 0 , '','',0,0);
  public item3 =Array<Item>();
  public user: User = JSON.parse(sessionStorage.getItem("loggedUser"));
  public itemID: Item = JSON.parse(sessionStorage.getItem("itemid"));
  public currentPrice: Item = JSON.parse(sessionStorage.getItem("curretPrice"));

  public cid = sessionStorage.getItem("cid");
  public cprice = sessionStorage.getItem("cprice");
  

  constructor(private _router:Router, private _itemService: ItemService) { }
  
  public getCategoryTag(): void {
    this._itemService.getItemBySeller(this.user).subscribe(
      data => {
       console.log(data);
       this.item3=<Item[]>data;
       
      },
      error => {
        console.log("Error");
      }

    )


  }
  ngOnInit() {
    if(this.user==null){
      console.log("null username");
      this._router.navigate(["/login"]);
    }else{
      console.log(this.user.username);
    }

    
  }
  logout(){
    sessionStorage.setItem("loggedUser", null);
    this._router.navigate(["/login"]);
  }
  setCid(string: string, string1:string ){
    sessionStorage.setItem("cid", string);
    console.log("saved" + sessionStorage.getItem("cid"));
    
    sessionStorage.setItem("cprice", string1);
    console.log("saved" + sessionStorage.getItem("cprice"));
  
  }
 
  public bid():void {
    this._itemService.bidItem(this.cid, this.cprice).subscribe(


    )
  }

}
