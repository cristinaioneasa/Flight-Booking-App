import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Flight} from "../model/Flight";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class FlightService{
  baseURL: string = "http://localhost:8081/flight";

  constructor(private httpClient: HttpClient) {}

  findAll(){
    return this.httpClient.get<Flight[]>(this.baseURL + "/findAll");
  }

  insertFlight(flight: Flight):Observable<Flight>{
    return this.httpClient.put<Flight>(this.baseURL + "/insertFlight", flight);
  }

  findByArrival(arrival: string){
    let params = new HttpParams().set('arrival', arrival);
    return this.httpClient.get(this.baseURL + "/findByArrival" + {params: params})
  }

}
