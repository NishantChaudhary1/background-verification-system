import { Component, OnInit } from '@angular/core';
import { BackgroundService } from '../background.service';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { LoginDto } from '../class/login-dto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userId:number;
  password:string;
  roleId:number;

  login_details:any;
  message:string;
  msg:any;
  check:boolean = false;
  check1:boolean = false;
  empId:number;
  
  constructor(private service:BackgroundService, private router:Router, private app1:AppComponent) { 
  }

  ngOnInit(): void {
  }
  fetchEmployee()
  {
    this.service.getlogindetails(this.userId,this.password,this.roleId).subscribe((data)=>{
      
      if(this.roleId==54045){
      this.router.navigate(['app-login-sucess'])
      console.log(this.userId)
      }
      else if(this.roleId==18018){
        this.router.navigate(['app-employeelogin-sucess'])
      }
      
    },
    error=>{
      this.msg="Invalid Credentials please try again"
    }
    )
  }
  }
