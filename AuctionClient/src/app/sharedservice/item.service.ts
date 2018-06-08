import { Injectable } from '@angular/core';
import {Http,Response,Headers, RequestOptions} from '@angular/http';
import { Router } from '@angular/router';
import {Observable} from 'rxjs';

import { map } from 'rxjs/operators';

import { User } from '../user';
import { Item } from '../models/item';
import { ClientMessage } from '../models/client-message';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private baseUrl:string ='http://localhost:8080/AuctionSite/item';
  private headers = new Headers({'content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});

  constructor(private http: Http) { 
    console.log("const ran for the services")
  }
  ///add/{itemName}/{description}/{currentPrice}/{categoryTag}/{image}/{timeLeft}
  //this.baseUrl+"/login"+ "/" +user.username + "/" + user.password, this.options
  public addItem(item:Item):Observable<ClientMessage>{
      return this.http.get(this.baseUrl+"/add" + "/" +item.itemName+ "/" +item.description+ "/"+ item.currentPrice+ "/" +item.categoryTag+ "/" +item.image+"/"+item.timeLeft, this.options).pipe(map((response:Response) => response.json()));
  }
  ///getByCategory/{categoryTag}")
  public getItemByCategory(item:Item):Observable<Item[]>{  
  
   return this.http.get(this.baseUrl+"/getByCategory"+"/"+item.categoryTag, this.options).pipe(map((response:Response) => response.json()));
}
//"/bid/{item_id}/{currentPrice}") //Seller id, item id, new bid price
public bidItem(item:Item):Observable<Item>{  
  
  return this.http.post(this.baseUrl+"/bid"+"/"+item.id+"/"+item.currentPrice, this.options).pipe(map((response:Response) => response.json()));
}
  errorHandler(error :Response){
    return Observable.throw("server Error");
  }
}