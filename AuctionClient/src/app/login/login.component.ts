import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserserviceService } from '../sharedservice/userservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 //  public user:User = new User(0,'','','','','',0,0,0,0,'','','','');
 //  public userdata:User = new User(0,'','','','','',0,0,0,0,'','','','');
 public user:User = new User(" "," ");
 public userData:User = new User('testname1','testpassword');
  constructor(private userservice:UserserviceService) { }

  ngOnInit() {
    
    console.log(this.user.username);
    console.log(this.user.password);
  }

  public login():void{
    this.userservice.getUser(this.user).subscribe(
      data =>{
       
        this.user=<User>data;            
        console.log(data);
        console.log(this.user.username);
        console.log(this.user.password);
      },
      error =>{
        console.log("Error");
      }

    )

 
  }

}
