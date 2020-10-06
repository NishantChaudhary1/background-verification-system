export class VerificationDto {
        verfId:number;
        status:string;
        startDate:Date;
        endDate:Date;
        constructor(verfId:number,status:string,startDate:Date, endDate:Date )
        {
          this.verfId=verfId;
          this.status=status;
          this.startDate=startDate;
          this.endDate=endDate;
        }
}
