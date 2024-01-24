package com.example.Service;


import com.example.Entity.Patient;
import com.example.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public PatientService() {
    }

    public List<Patient> getAllPatients() {
        return this.patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return (Patient)this.patientRepository.findById(id).orElse((Patient) null);
    }

    public Patient createPatient(Patient patient) {
        return (Patient)this.patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patient) {
        if (this.patientRepository.existsById(id)) {
            patient.setId(id);
            return (Patient)this.patientRepository.save(patient);
        } else {
            return null;
        }
    }

    public void deletePatient(Long id) {
        this.patientRepository.deleteById(id);
    }
}
