import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimenumberComponent } from './primenumber.component';
import { FormsModule } from '@angular/forms';

describe('PrimenumberComponent', () => {
  let component: PrimenumberComponent;
  let fixture: ComponentFixture<PrimenumberComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PrimenumberComponent],
      imports: [FormsModule]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PrimenumberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should check if a number is prime', () => {
    component.number = 7;
    component.checkPrime();
    expect(component.isPrime).toBe(true);
  });

  it('should check if a number is not prime', () => {
    component.number = 4;
    component.checkPrime();
    expect(component.isPrime).toBe(false);
  });
});
