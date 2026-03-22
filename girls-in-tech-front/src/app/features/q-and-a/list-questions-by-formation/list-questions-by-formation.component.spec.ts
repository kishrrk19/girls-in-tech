import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListQuestionsByFormationComponent } from './list-questions-by-formation.component';

describe('ListQuestionsByFormationComponent', () => {
  let component: ListQuestionsByFormationComponent;
  let fixture: ComponentFixture<ListQuestionsByFormationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListQuestionsByFormationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListQuestionsByFormationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
