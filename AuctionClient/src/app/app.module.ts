import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';

import {
  MatButtonModule,
  MatMenuModule,
  MatToolbarModule,
  MatIconModule,
  MatCardModule
} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatChipsModule } from '@angular/material/chips';


import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NavigationComponent } from './navigation/navigation.component';
import { UserserviceService } from './sharedservice/userservice.service';
import { ElectronicsComponent } from './electronics/electronics.component';
import { FurnitureComponent } from './furniture/furniture.component';
import { ToysComponent } from './toys/toys.component';
import { ApparelComponent } from './apparel/apparel.component';
import { AntiquesComponent } from './antiques/antiques.component';
import { ProfileComponent } from './profile/profile.component';



const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'electronics', component: ElectronicsComponent },
  { path: 'furniture', component: FurnitureComponent },
  { path: 'toys', component: ToysComponent },
  { path: 'apparel', component: ApparelComponent },
  { path: 'antiques', component: AntiquesComponent },
  { path: 'profile', component: ProfileComponent },
  {
    path: 'login', component: LoginComponent,
    children: [
      {
        path: 'home',
        component: HomeComponent
      }
    ]
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    HomeComponent,
    LoginComponent,
    ElectronicsComponent,
    FurnitureComponent,
    ToysComponent,
    ApparelComponent,
    AntiquesComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    BrowserAnimationsModule,
    MatChipsModule,
    RouterModule.forRoot(
      appRoutes
    )
  ],
  providers: [UserserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
