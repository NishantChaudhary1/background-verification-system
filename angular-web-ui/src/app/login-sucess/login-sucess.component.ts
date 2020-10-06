import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-sucess',
  templateUrl: './login-sucess.component.html',
  styleUrls: ['./login-sucess.component.css']
})
export class LoginSucessComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  logout(){


    sessionStorage.clear();
    
      this.router.navigate(['']);
    
    }

}
