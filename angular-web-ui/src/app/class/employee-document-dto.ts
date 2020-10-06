import { VerificationDto } from './verification-dto';

export class EmployeeDocumentDto {
    empId:number;
  docId:number;
  docType:string;
  docData:string;
  empName:string;
  verificationDto:VerificationDto
  constructor(empId:number,docId:number,docType:string,docData:string,empName:string,verificationDto:VerificationDto){
    this.empId = empId;
    this.docId = docId;
    this.docType = docType;
    this.empName=empName;
    this.verificationDto=verificationDto;
}
}
