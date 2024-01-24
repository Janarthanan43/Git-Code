import { Component, OnInit } from '@angular/core';
import { Patient } from './patient';
import { PatientService } from './patient.service';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrl: './patient.component.css'
})
export class PatientComponent implements OnInit{

  patients: Patient[] = [];
  newPatient: Patient = {} as Patient; // Empty Patient object for adding new patient
  selectedPatient: Patient | undefined; // Selected patient for updating

  constructor(private patientService: PatientService) { }

  ngOnInit(): void {
    this.loadPatients();
  }

  private loadPatients(): void {
    this.patientService.getAllPatients().subscribe(
      data => {
        this.patients = data;
      },
      error => {
        console.error('Error loading patients:', error);
      }
    );
  }

  // Method to add a new patient
  addPatient(): void {
    this.patientService.addPatient(this.newPatient).subscribe(
      data => {
        this.patients.push(data);
        this.newPatient = {} as Patient; // Clear the form
      },
      error => {
        console.error('Error adding patient:', error);
      }
    );
  }

  // Method to update a patient
  updatePatient(): void {
    if (this.selectedPatient) {
      this.patientService.updatePatient(this.selectedPatient.id!, this.selectedPatient).subscribe(
        data => {
          // Update the patient in the list
          const index = this.patients.findIndex(patient => patient.id === data.id);
          if (index !== -1) {
            this.patients[index] = data;
          }
          this.selectedPatient = undefined; // Clear the selected patient
        },
        error => {
          console.error('Error updating patient:', error);
        }
      );
    }
  }

  // Method to delete a patient
  deletePatient(patient: Patient): void {
    this.patientService.deletePatient(patient.id!).subscribe(
      () => {
        // Remove the patient from the list
        this.patients = this.patients.filter(p => p.id !== patient.id);
      },
      error => {
        console.error('Error deleting patient:', error);
      }
    );
  }

  // Method to select a patient for updating
  selectPatientForUpdate(patient: Patient): void {
    this.selectedPatient = { ...patient }; // Create a copy of the selected patient
  }

  // Method to cancel the update operation
  cancelUpdate(): void {
    this.selectedPatient = undefined;
  }

}
