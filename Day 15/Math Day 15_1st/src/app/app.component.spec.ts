import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { PrimenumberComponent } from './primenumber/primenumber.component';
import { FormsModule } from '@angular/forms';
import { FactorialComponent } from './factorial/factorial.component';
import { ArmstrongNumberCheckerComponent } from './armstrong-number-checker/armstrong-number-checker.component';
import { InvertedPyramidComponent } from './inverted-pyramid/inverted-pyramid.component';
import { AtmTransactionComponent } from './atm-transaction/atm-transaction.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        FormsModule
      ],
      declarations: [
        AppComponent,
        PrimenumberComponent,
        FactorialComponent,
        ArmstrongNumberCheckerComponent,
        InvertedPyramidComponent,
        AtmTransactionComponent
      ],
      
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'angular-math-app'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('angular-math-app');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Welcome to Angular Math App');
  });
});
