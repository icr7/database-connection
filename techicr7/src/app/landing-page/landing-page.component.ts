import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  
  getLoginPage(){
    this.router.navigate(['July/user/Login']);
  }
  getSignUpPage(){
    this.router.navigate(['July/user/SignUpPage']);
  }

}
