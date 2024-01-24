import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientComponent } from './patient.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { PatientService } from './patient.service';
import { Patient } from './patient';
import { of } from 'rxjs';


describe('PatientComponent', () => {
  let component: PatientComponent;
  let fixture: ComponentFixture<PatientComponent>;
  let patientService: jasmine.SpyObj<PatientService>;


  beforeEach(async () => {
    const patientServiceSpy = jasmine.createSpyObj('PatientService', ['viewAllPatients', 'deletePatient']);

    await TestBed.configureTestingModule({
      declarations: [PatientComponent],
      imports: [HttpClientTestingModule,
                FormsModule],
      providers: [{ provide: PatientService, useValue: patientServiceSpy }]

    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PatientComponent);
    component = fixture.componentInstance;
    patientService = TestBed.inject(PatientService) as jasmine.SpyObj<PatientService>;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  

  it('should delete a patient', () => {
    const patientToDelete: Patient = { id: 1, name: 'Naveen', disease: 'Fever', doc: 'Jana', stage: 'normal' };

    patientService.deletePatient.and.returnValue(of(patientToDelete));

    component.deletePatient(patientToDelete.id);

    expect(component.patients).not.toContain(patientToDelete);
  });

  it('should return CSS class based on the patient\'s stage', () => {
    expect(component.getStageClass('normal')).toBe('normal-stage');
    expect(component.getStageClass('severe')).toBe('severe-stage');
    expect(component.getStageClass('critical')).toBe('critical-stage');
    expect(component.getStageClass('unknown')).toBe('');
  });
});
