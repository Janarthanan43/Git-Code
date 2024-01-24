import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient } from './patient';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http:HttpClient)
  {

  }

  patients: Patient[] | any;

  private apiGet:string="http://localhost:8098/api/patients";
  private apiPost:string="http://localhost:8098/api/patients";
  private apiGetById:string="http://localhost:8098/api/patients";
  private apiPut:string="http://localhost:8098/api/patients";
  private apiDelete:string="http://localhost:8098/api/patients";

  addPatient(patient: Patient): Observable<Patient> {
   return this.http.post<Patient>(this.apiPost, patient);
  }

  getAllPatients(): Observable<Patient[]> {
       return this.http.get<Patient[]>(this.apiGet);
     }
 deletePatient(id: number): Observable<void> {
     return this.http.delete<void>(`${this.apiDelete}/${id}`);
 }
 getPatientById(id: number): Observable<Patient> {
     return this.http.get<Patient>(`${this.apiGetById}/${id}`);
     
   }

   updatePatient(id: number, patient: Patient): Observable<Patient> {
       return this.http.put<Patient>(`${this.apiPut}/${id}`, patient);
     }
}
