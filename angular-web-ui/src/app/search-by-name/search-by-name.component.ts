import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BackgroundService } from '../background.service';
import { EmployeeDocumentDto } from '../class/employee-document-dto';

@Component({
  selector: 'app-search-by-name',
  templateUrl: './search-by-name.component.html',
  styleUrls: ['./search-by-name.component.css']
})
export class SearchByNameComponent implements OnInit {

  empName:string;
  emp_docdetails:any;
  message:string;
  private router:Router;
  
  check:boolean = false;
  check1:boolean = false;
  completeData: EmployeeDocumentDto;
  base64Data: string;
  retrievedImage: string;
  
  constructor(private service:BackgroundService,router:Router) { 
    this.router=router;
  }


  ngOnInit(): void {
  }


  fetchEmployeedocument()
  {
    this.service.getdocumentbyname(this.empName).subscribe(res=>{
      this.completeData=res[0];
      this.base64Data=this.completeData.docData;
      this.retrievedImage='data:image/jpg;base64,' + this.base64Data;
    },
    error=>{
      this.message = error, JSON.stringify(this.message)
    }
    
      )
  }
 
}