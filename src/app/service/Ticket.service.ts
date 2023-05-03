import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ticket} from "../model/Ticket";

@Injectable({
  providedIn: 'root'
})
export class TicketService{
  baseURL: string = "http://localhost:8081/ticket";

  constructor(private httpClient: HttpClient) {
  }

  insertUser(number: any, email:any, seat:any){
    return this.httpClient.put<Ticket>(this.baseURL + '/insertTicket?number=' + number + '&email=' + email + '&seat=' +seat, null);
  }

}
