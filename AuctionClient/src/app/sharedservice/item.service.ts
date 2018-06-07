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
  public addItem(item:Item):Observable<ClientMessage>{
      return this.http.post(this.baseUrl+"/add" ,item).pipe(map((response:Response) => response.json()));
  }

  errorHandler(error :Response){
    return Observable.throw("server Error");
  }
}