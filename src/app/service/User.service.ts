import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {User} from "../model/User";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class UserService{
  baseURL: string = "http://localhost:8081/user";

  userLoggedInfo: any;
  userLoggedId: number | undefined;

  constructor(private httpClient: HttpClient) {
  }

  loginUser(user: User):Observable<object> {
    console.log(user);
    return this.httpClient.post(this.baseURL + '/login', user);
  }

  loginAdmin(user: User):Observable<object> {
    console.log(user);
    return this.httpClient.post(this.baseURL + '/loginAdmin', user);
  }

  insertUser(user: User): Observable<User>{
    return this.httpClient.post<User>(this.baseURL + '/insertUser', user);
  }
}
