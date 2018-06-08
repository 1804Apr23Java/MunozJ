import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  

  btnTextShow: string = 'Login';
  btnTextHide: string = 'User Login';
  
 

  btnText: string = this.btnTextHide;
  toggle(): void{
    if (this.btnText === this.btnTextShow){
      this.btnText = this.btnTextHide;
    }else{
      this.btnText = this.btnTextShow;
    }
  }
  constructor() { }

  ngOnInit() {
  }

}
