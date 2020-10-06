import { Component, OnInit } from '@angular/core';
import { BackgroundService } from '../background.service';
import { Router } from '@angular/router';
import { VerificationDto } from '../class/verification-dto';

@Component({
  selector: 'app-set-status',
  templateUrl: './set-status.component.html',
  styleUrls: ['./set-status.component.css']
})
export class SetStatusComponent implements OnInit {

  verification:VerificationDto=new VerificationDto(0,"",null,null);
  private router:Router
  message:string;
  errorMsg: string ;
  check:boolean;
  check1: boolean ;
  constructor(private service:BackgroundService,router:Router) { 
    this.router=router;
  }

  ngOnInit(): void {  
  }
  
  status(){
    if(this.verification.verfId != 0 && this.verification.status != ""){
      this.service.setstatus(this.verification, this.verification.verfId).subscribe((data)=>{
        this.message=data
        this.check1 = true
      },
      error=>
      {
        this.errorMsg = error, JSON.stringify(this.errorMsg)
      }
        );
      
  }
  
      
  } 
}

























