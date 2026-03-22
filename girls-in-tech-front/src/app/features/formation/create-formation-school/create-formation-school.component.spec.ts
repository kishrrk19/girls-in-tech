import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFormationSchoolComponent } from './create-formation-school.component';

describe('CreateFormationSchoolComponent', () => {
  let component: CreateFormationSchoolComponent;
  let fixture: ComponentFixture<CreateFormationSchoolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateFormationSchoolComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateFormationSchoolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
