import { Component } from '@angular/core';
import { Patient } from './patient';
import { PatientService } from './patient.service';
 
@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.scss'],
})
export class PatientComponent{
  
  constructor(private service: PatientService) {}

  
 
  newPatient: Patient = { id: 0, name: '', disease: '', doc: '', stage: '' };
  patients: Patient[] = [];
  username: string = '';
  isAdmin: boolean = false;
 
  

  addPatient() {
    // if (this.isAdmin) {
      this.service.addPatient(this.newPatient).subscribe(
        (data) => {
          this.patients.push(data);
        },
        (error) => {
          console.log(error);
        }
      );
      this.newPatient = { id: 0, name: '', disease: '', doc: '', stage: '' };
   // }
  }
 
  getAllPatients() {
    this.service.viewAllPatients().subscribe(
      (data) => {
        this.patients = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }
 
  deletePatient(id: number) {
    // if (this.isAdmin) {
      this.service.deletePatient(id).subscribe(
        () => {
          this.patients = this.patients.filter((p) => p.id !== id);
        },
        (error) => {
          console.log(error);
        }
      );
    // }
  }
 
  // Function to get the CSS class based on the patient's stage
  getStageClass(stage: string): string {
    switch (stage) {
      case 'normal':
        return 'normal-stage';
      case 'severe':
        return 'severe-stage';
      case 'critical':
        return 'critical-stage';
      default:
        return '';
    }
  }
}