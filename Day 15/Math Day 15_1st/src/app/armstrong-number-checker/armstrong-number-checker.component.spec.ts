import { TestBed, ComponentFixture } from '@angular/core/testing';
import { ArmstrongNumberCheckerComponent } from './armstrong-number-checker.component';

describe('ArmstrongNumberCheckerComponent', () => {
  let component: ArmstrongNumberCheckerComponent;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ArmstrongNumberCheckerComponent],
    });

    const fixture: ComponentFixture<ArmstrongNumberCheckerComponent> = TestBed.createComponent(ArmstrongNumberCheckerComponent);
    component = fixture.componentInstance;
  });

  it('should check if an Armstrong number', () => {
    component.number = 153;
    component.checkArmstrong();
    expect(component.isArmstrong).toBe(true);
  });

  it('should check if not an Armstrong number', () => {
    component.number = 123;
    component.checkArmstrong();
    expect(component.isArmstrong).toBe(false);
  });
});
