import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmationCreationQuestionComponent } from './confirmation-creation-question.component';

describe('ConfirmationCreationQuestionComponent', () => {
  let component: ConfirmationCreationQuestionComponent;
  let fixture: ComponentFixture<ConfirmationCreationQuestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConfirmationCreationQuestionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ConfirmationCreationQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
