package com.rocktech.hospital.controller;

import com.rocktech.hospital.model.Patient;
import com.rocktech.hospital.model.Staff;
import com.rocktech.hospital.service.PatientService;
import com.rocktech.hospital.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("api/patient/")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> patientList(){
        return patientService.getPatientsByAge();
    }

    @GetMapping("{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("patientId") Long patientId){
        return ResponseEntity.ok(patientService.getPatientById(patientId).get());
    }

    @PostMapping("add-patient")
    public void addPatient(@RequestBody Patient patient) throws ParseException {
        patientService.addPatient(patient);
    }

    @DeleteMapping("delete-patients/{startDate}/{endDate}")
    public void deletePatients( @PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
        patientService.deletePatients(startDate, endDate);
    }
}
