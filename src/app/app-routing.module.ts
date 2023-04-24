import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstPageComponent } from './component/first-page/first-page.component';
import {LoginComponent} from "./component/login/login.component";
import {RegisterComponent} from "./component/register.component/register.component";
import {ClientComponent} from "./component/client/client.component";
import {AdminComponent} from "./component/admin/admin.component";

const routes: Routes = [
  {path: '', component:FirstPageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'client', component: ClientComponent},
  {path: 'admin', component: AdminComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
