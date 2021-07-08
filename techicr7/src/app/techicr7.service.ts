import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Techicr7Service {


  constructor(private http:HttpClient) { }

  saveUser(user: Object): Observable<Object> {
    return this.http.post(`http://localhost:8085/July/user/SignUpPage`, user);
  }


}

