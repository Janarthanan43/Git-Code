import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  // Simulating user data (replace with actual authentication logic)
  private users = [
    { username: 'Naveen', password: 'Naveenjana' },
    { username: 'Jana', password: 'Naveenjana' },
    // Add more users as needed
  ];
 
  private isAuthenticatedValue: boolean = false;
 
  // Simulating an authentication check
  authenticate(username: string, password: string): Observable<boolean> {
    const user = this.users.find(u => u.username === username && u.password === password);
    this.isAuthenticatedValue = !!user; // Set authentication status
    return of(this.isAuthenticatedValue); // Return true if the user is found, false otherwise
  }
  setAuthenticated(value: boolean): void {     
    this.isAuthenticatedValue = value;  
   }
  isAuthenticated(): boolean {
    return this.isAuthenticatedValue;
  }
}