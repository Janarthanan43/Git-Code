import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { PatientService } from './patient.service';
import { Patient } from './patient';

describe('PatientService', () => {
  let service: PatientService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [PatientService]
    });
    service = TestBed.inject(PatientService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    // After each test, verify that there are no outstanding requests
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should add a patient', () => {
    const dummyPatient: Patient = { id: 1, name: 'Naveen', disease: 'Fever', doc: 'Jana', stage: 'normal' };

    service.addPatient(dummyPatient).subscribe(patient => {
      expect(patient).toEqual(dummyPatient);
    });

    const req = httpMock.expectOne(service.apiUrl);
    expect(req.request.method).toBe('POST');
    req.flush(dummyPatient);
  });

  it('should retrieve all patients', () => {
    const dummyPatients: Patient[] = [
      { id: 1, name: 'Naveen', disease: 'Fever', doc: 'Jana', stage: 'normal' },
      { id: 2, name: 'Roger', disease: 'Cold', doc: 'Federer', stage: 'severe' }
    ];

    service.viewAllPatients().subscribe(patients => {
      expect(patients).toEqual(dummyPatients);
    });

    const req = httpMock.expectOne(service.apiUrl);
    expect(req.request.method).toBe('GET');
    req.flush(dummyPatients);
  });

  it('should delete a patient', () => {
    const patientId = 1;

    service.deletePatient(patientId).subscribe(patient => {
      expect(patient.id).toBe(patientId);
    });

    const req = httpMock.expectOne(`${service.apiUrl}/${patientId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush({ id: patientId });
  });
});
