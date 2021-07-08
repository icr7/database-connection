import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class Techicr7Service {

  temp:User=new User();
  constructor(private http:HttpClient) { }

  saveUser(user: Object): Observable<Object> {
    return this.http.post(`http://localhost:8085/July/user/SignUpPage`, user);
  }

  getUser(email:string,password:string):Observable<any>{
    return this.http.get(`http://localhost:8085/July/user/loginPage/${email}/${password}`);
  }

  communicateData(msg){

    this.temp=msg;
 
   }
   communicate(){
     return this.temp;
   }

}

