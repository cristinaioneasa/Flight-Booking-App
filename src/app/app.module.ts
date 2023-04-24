import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstPageComponent } from './component/first-page/first-page.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatListModule} from '@angular/material/list';
import {LoginComponent} from "./component/login/login.component";
import {RegisterComponent} from "./component/register.component/register.component";
import {ClientComponent} from "./component/client/client.component";
import {AdminComponent} from "./component/admin/admin.component";

@NgModule({
  declarations: [
    AppComponent,
    FirstPageComponent,
    LoginComponent,
    RegisterComponent,
    ClientComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatListModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
