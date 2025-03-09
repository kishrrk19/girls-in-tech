import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationListHomeComponent } from './formation-list-home.component';

describe('FormationListHomeComponent', () => {
  let component: FormationListHomeComponent;
  let fixture: ComponentFixture<FormationListHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormationListHomeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormationListHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
