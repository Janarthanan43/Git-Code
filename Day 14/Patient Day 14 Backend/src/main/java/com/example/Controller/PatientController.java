package com.example.Controller;




import com.example.Entity.Patient;
import com.example.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/api/patients"})
@CrossOrigin({"*"})
public class PatientController {
    @Autowired
    private PatientService patientService;

    public PatientController() {
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return this.patientService.getAllPatients();
    }

    @GetMapping({"/{id}"})
    public Patient getPatientById(@PathVariable Long id) {
        return this.patientService.getPatientById(id);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return this.patientService.createPatient(patient);
    }

    @PutMapping({"/{id}"})
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return this.patientService.updatePatient(id, patient);
    }

    @DeleteMapping({"/{id}"})
    public void deletePatient(@PathVariable Long id) {
        this.patientService.deletePatient(id);
    }
}
