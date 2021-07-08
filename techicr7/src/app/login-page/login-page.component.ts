import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Techicr7Service } from '../techicr7.service';
import { User } from '../user';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  user: User= new User();
  profile;
  message:any;
  submitted =false;

  constructor(private techicr7service:Techicr7Service,
    private router: Router) { }

  ngOnInit(): void {

  }
  get(){
    this.techicr7service
    .getUser(this.user.email,this.user.passWord).subscribe(data => {
      console.log(data.status)
      this.profile= data.entity;
      console.log(this.profile);
      this.message=data.status;
      if(this.message="login successful"){
        this.gotoProfile();
      }
    },
    error => console.log(error));
  }

  onSub() {
    this.submitted = true;
    this.get(); 

  }
  gotoProfile() {
    this.techicr7service.communicateData(this.profile);
    this.router.navigate(['/July/user/Profile']);
  }

}