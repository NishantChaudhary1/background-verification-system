import { Component, OnInit } from '@angular/core';
import { BackgroundService } from '../background.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-status',
  templateUrl: './view-status.component.html',
  styleUrls: ['./view-status.component.css']
})
export class ViewStatusComponent implements OnInit {

  
  verfId:number;
  verification_details:any;
  message:string;
  private router:Router;
  message1:string;
  message2:string;
  message3:string;
  result:string;
  check:boolean = false;
  check1:boolean = false;
  
  constructor(private service:BackgroundService,router:Router) { 
    this.router=router;
  }


  ngOnInit(): void {
  }



  status(){
    this.service.getstatus(this.verfId).subscribe((data)=>{
      this.verification_details=data
      console.log(this.verification_details.status)
      if(this.verification_details==null){
       
        this.check= true;
        this.check1=false;
        this.result='Verification Id not found';
      }
      else{
        this.check=false;
        this.check1=true;
      this.message=this.verification_details.status;
      this.message1=this.verification_details.startDate;
      this.message2=this.verification_details.endDate;
      if(this.message2==null)
      {
        this.message2="null"
      }
      else
      {
        this.message2=this.message2;
      }
      }
    }
    ,
    error=>{
      this.message = error, JSON.stringify(this.message)
    });
  }
}
