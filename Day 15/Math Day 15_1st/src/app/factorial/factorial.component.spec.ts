import { TestBed, ComponentFixture } from '@angular/core/testing';
import { FactorialComponent } from './factorial.component';

describe('FactorialComponent', () => {
  let component: FactorialComponent;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FactorialComponent],
    });

    const fixture: ComponentFixture<FactorialComponent> = TestBed.createComponent(FactorialComponent);
    component = fixture.componentInstance;
  });

  it('should calculate factorial of 5', () => {
    component.number = 5;
    component.calculateFactorial();
    expect(component.result).toBe(120);
  });

  it('should calculate factorial of 0', () => {
    component.number = 0;
    component.calculateFactorial();
    expect(component.result).toBe(1);
  });
});
