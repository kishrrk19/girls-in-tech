import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionResponseDetailComponent } from './question-response-detail.component';

describe('QuestionResponseDetailComponent', () => {
  let component: QuestionResponseDetailComponent;
  let fixture: ComponentFixture<QuestionResponseDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [QuestionResponseDetailComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(QuestionResponseDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
