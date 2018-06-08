import { Injectable } from '@angular/core';
import {Http,Response,Headers, RequestOptions} from '@angular/http';
import { Router } from '@angular/router';
import {Observable} from 'rxjs';

import { map } from 'rxjs/operators';

import { User } from '../user';




@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
  private baseUrl:string ='http://localhost:8080/AuctionSite/user';
  private headers = new Headers({'content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private name;

  constructor(private http: Http) { 
    console.log("const ran for the services")
  }
 
  getUser(user:User):Observable<Object>{
      this.name=user.username;
      console.log(this.name);
      return this.http.get(this.baseUrl+"/login"+ "/" +user.username + "/" + user.password, this.options).pipe(map((response:Response) => response.json()));
  }
  public getLoggedUser(): User {
    let str = sessionStorage.getItem("loggedUser");
 
    if(str){
      let obj: Object = <Object>JSON.parse(str);
      if(obj.hasOwnProperty("username")){
        return <User>obj;
      }
    }
    return null;
  }
  errorHandler(error :Response){
    return Observable.throw("server Error");
  }
}
