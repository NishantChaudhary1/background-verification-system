import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BackgroundService } from './background.service';
import { HttpClientModule } from '@angular/common/http';
import { SearchByIdComponent } from './search-by-id/search-by-id.component';
import { SearchByNameComponent } from './search-by-name/search-by-name.component';
import { SetStatusComponent } from './set-status/set-status.component';
import { LoginSucessComponent } from './login-sucess/login-sucess.component';
//import { EmployeeLoginComponent } from './employee-login/employee-login.component';
import { EmployeeloginSucessComponent } from './employeelogin-sucess/employeelogin-sucess.component';
import { UploadDocumentComponent } from './upload-document/upload-document.component';
import { ViewStatusComponent } from './view-status/view-status.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SearchByIdComponent,
    SearchByNameComponent,
    SetStatusComponent,
    LoginSucessComponent,
    EmployeeloginSucessComponent,
    UploadDocumentComponent,
    ViewStatusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    
    
    HttpClientModule,
    ReactiveFormsModule,
    
    
  
  ],
  providers: [BackgroundService],
  bootstrap: [AppComponent]
})
export class AppModule { }


