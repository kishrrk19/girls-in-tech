import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationSchoolComponent } from './formation-school.component';

describe('FormationSchoolComponent', () => {
  let component: FormationSchoolComponent;
  let fixture: ComponentFixture<FormationSchoolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormationSchoolComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormationSchoolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
