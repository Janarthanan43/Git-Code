import { Component } from '@angular/core';

@Component({
  selector: 'app-primenumber',
  templateUrl: './primenumber.component.html',
  styleUrls: ['./primenumber.component.css']  // Use styleUrls instead of styleUrl
})
export class PrimenumberComponent {
  number: number = 0;
  isPrime: boolean = false;

  checkPrime() {
    if (this.number <= 1) {
      // Numbers less than or equal to 1 are not prime
      this.isPrime = false;
    } else {
      // Check for divisibility from 2 to the square root of the number
      const sqrt = Math.sqrt(this.number);
      for (let i = 2; i <= sqrt; i++) {
        if (this.number % i === 0) {
          // If the number is divisible by any i, it's not a prime number
          this.isPrime = false;
          return;
        }
      }
      // If no divisor is found, it's a prime number
      this.isPrime = true;
    }
  }
}
