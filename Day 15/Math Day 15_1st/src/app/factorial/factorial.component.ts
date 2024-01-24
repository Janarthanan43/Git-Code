// factorial.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-factorial',
  templateUrl: './factorial.component.html',
  styleUrls: ['./factorial.component.css']
})
export class FactorialComponent {
  number: number=0;
  result: number=1;

  calculateFactorial() {
    if (this.number < 0) {
      // Factorial is not defined for negative numbers
      this.result = NaN;
      return;
    }

    // Initialize result to 1, as the factorial of 0 is 1
    this.result = 1;

    // Multiply numbers from 1 to this.number to calculate factorial
    for (let i = 1; i <= this.number; i++) {
      this.result *= i;
    }
  }
}
