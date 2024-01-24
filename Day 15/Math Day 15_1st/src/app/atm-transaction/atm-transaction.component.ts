// atm-transaction.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-atm-transaction',
  templateUrl: './atm-transaction.component.html',
  styleUrls: ['./atm-transaction.component.css']
})
export class AtmTransactionComponent {
  balance: number = 1000; // Initial balance, you can set it to any desired value
  withdrawalAmount!: number; // Use the definite assignment assertion

  withdraw(amount: number) {
    if (amount === undefined || amount <= 0) {
      // Withdrawal amount should be positive
      console.log("Please enter a valid withdrawal amount.");
      return;
    }

    if (amount > this.balance) {
      // Insufficient funds
      console.log("Insufficient funds. Withdrawal canceled.");
      return;
    }

    // Process withdrawal
    this.balance -= amount;
    console.log(`Successfully withdrew $${amount}. Remaining balance: $${this.balance}`);
  }
}
