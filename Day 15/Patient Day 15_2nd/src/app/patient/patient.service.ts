import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Patient } from './patient';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class PatientService {
 
  public apiUrl="http://localhost:3000/posts";
 
  constructor(private http: HttpClient) {}
 
  addPatient(patient: Patient): Observable<Patient> {
    return this.http.post<Patient>(this.apiUrl, patient);
  }
 
  viewAllPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.apiUrl);
  }
 
  deletePatient(id: number): Observable<Patient> {
    return this.http.delete<Patient>(`${this.apiUrl}/${id}`);
  }
}