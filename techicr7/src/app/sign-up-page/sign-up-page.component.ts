import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Techicr7Service } from '../techicr7.service';
import { User } from '../user';

@Component({
  selector: 'app-sign-up-page',
  templateUrl: './sign-up-page.component.html',
  styleUrls: ['./sign-up-page.component.css']
})
export class SignUpPageComponent implements OnInit {
  
  user: User= new User();
  message:any;
  submitted =false;
  constructor(private techicr7service:Techicr7Service,
    private router: Router) { }
  
  ngOnInit(): void {
    this.submitted=false;
    this.user=new User();
  }

  save(){
    this.techicr7service
    .saveUser(this.user).subscribe(data => {
      console.log(data)
      this.user=new User();
    },
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }
 

}
