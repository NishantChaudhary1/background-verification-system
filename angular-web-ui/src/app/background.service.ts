import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { EmployeeDocumentDto } from './class/employee-document-dto';
import { VerificationDto } from './class/verification-dto';
import { LoginDto } from './class/login-dto';


@Injectable({
  providedIn: 'root'
})
export class BackgroundService {

  constructor(private http:HttpClient) { }

  logindto:LoginDto;
  employeedocumentdto:EmployeeDocumentDto;
  verification:VerificationDto;
  public getlogindetails(empId:number,password:string,roleId:number){
    
    return this.http.get("http://localhost:9091/BackGroundVerification/Login/"+empId+"/"+password+"/"+roleId)
    .pipe(catchError(this.handleError)) ;
  
  }
  public getdocumentbyid(empId:number){
  
  return this.http.get<EmployeeDocumentDto>("http://localhost:9090/BackGroundVerification/GetDocumentById/"+empId)
        .pipe(catchError(this.handleError)) ;
  
  }
  public getdocumentbyname(empName:string){
    
    return this.http.get("http://localhost:9090/BackGroundVerification/GetDocumentByName/"+empName,{responseType: 'json'})
    .pipe(catchError(this.handleError)) ;
  
  }
  
  
  public setstatus(verf: VerificationDto, verfId: number){
    return this.http.put("http://localhost:9090/BackGroundVerification/SetStatus/"+verfId,verf,{responseType: 'text'})
    .pipe(catchError(this.handleError)) ;
  }

  public saveEmployeeProfile(formdata:FormData):Observable<any>{

    return this.http.post("http://localhost:9090/BackgroundVerification-EmployeePortal/UploadDocument",formdata)
    .pipe(catchError(this.handleError)) ;
  
  }
  public getstatus(verfId:number){
    
    return this.http.get("http://localhost:9090/BackgroundVerification-EmployeePortal/ViewStatus/"+verfId,{responseType: 'json'})
    .pipe(catchError(this.handleError)) ;
  
  }
  private handleError(error : HttpErrorResponse){
    return throwError(error.error || "Server error") ;
  } 

}

