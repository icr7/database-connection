import { Component, OnInit } from '@angular/core';
import { Techicr7Service } from '../techicr7.service';
import { LoginPageComponent } from '../login-page/login-page.component'; 
import { User } from '../user';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {
profile;
  constructor(private techicr7service :Techicr7Service) { }

  ngOnInit() {
    this.profile=this.techicr7service.communicate();
      console.log(this.profile)
    }

  }