import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateFormationSchoolComponent } from './update-formation-school.component';

describe('UpdateFormationSchoolComponent', () => {
  let component: UpdateFormationSchoolComponent;
  let fixture: ComponentFixture<UpdateFormationSchoolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateFormationSchoolComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateFormationSchoolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
