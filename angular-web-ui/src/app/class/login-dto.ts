export class LoginDto {
    empId:number;
  password:string;
  roleId:number;
  constructor(empId:number, password:string, roleId:number){
    this.empId = empId;
    this.password = password;
    this.roleId = roleId;
}
}
