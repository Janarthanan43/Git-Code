
import { Pipe, PipeTransform } from '@angular/core';
 
@Pipe({

  name: 'lockerCharge'

})

export class LockerChargePipe implements PipeTransform {

  transform(balance: number): number {     
    console.log('Locker Charge Pipe Called. Input Balance:', balance);          
    const deduction = balance * 0.01;    
     const result = balance - deduction;    
     console.log('Deduction:', deduction);     
     console.log('Result:', result);    
   return result;

  }

}
