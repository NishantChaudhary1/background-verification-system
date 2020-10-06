import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SearchByIdComponent } from './search-by-id/search-by-id.component';
import { SearchByNameComponent } from './search-by-name/search-by-name.component';
import { SetStatusComponent } from './set-status/set-status.component';
import { LoginSucessComponent } from './login-sucess/login-sucess.component';
import { EmployeeloginSucessComponent } from './employeelogin-sucess/employeelogin-sucess.component';
import { ViewStatusComponent } from './view-status/view-status.component';
import { UploadDocumentComponent } from './upload-document/upload-document.component';


const routes: Routes = [
  
  {path:'',component:LoginComponent},
  {path:'app-login',component:LoginComponent},
  
  {
    path: 'app-login-sucess',
    component: LoginSucessComponent,
    children: [
      {path:'app-search-by-id',component:SearchByIdComponent},
      {path:'app-search-by-name',component:SearchByNameComponent},
      {path:'app-set-status',component:SetStatusComponent}
      ]
  },
  {
     path:'app-employeelogin-sucess',
     component:EmployeeloginSucessComponent,
     children:[
       {path:'app-view-status',component:ViewStatusComponent},
       {path:'app-upload-document',component:UploadDocumentComponent}
     ]
  }
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }





