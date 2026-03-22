import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAndDeleteFormationComponent } from './update-and-delete-formation.component';

describe('UpdateAndDeleteFormationComponent', () => {
  let component: UpdateAndDeleteFormationComponent;
  let fixture: ComponentFixture<UpdateAndDeleteFormationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateAndDeleteFormationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateAndDeleteFormationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
