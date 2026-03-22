import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationSchoolDetailComponent } from './formation-school-detail.component';

describe('FormationSchoolDetailComponent', () => {
  let component: FormationSchoolDetailComponent;
  let fixture: ComponentFixture<FormationSchoolDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormationSchoolDetailComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormationSchoolDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
