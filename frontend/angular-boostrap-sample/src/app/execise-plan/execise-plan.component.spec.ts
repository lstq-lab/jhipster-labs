import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExecisePlanComponent } from './execise-plan.component';

describe('ExecisePlanComponent', () => {
  let component: ExecisePlanComponent;
  let fixture: ComponentFixture<ExecisePlanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExecisePlanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExecisePlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
