import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeloginSucessComponent } from './employeelogin-sucess.component';

describe('EmployeeloginSucessComponent', () => {
  let component: EmployeeloginSucessComponent;
  let fixture: ComponentFixture<EmployeeloginSucessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeloginSucessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeloginSucessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
