package com.rocktech.hospital.service;

import com.rocktech.hospital.model.Patient;
import com.rocktech.hospital.model.Staff;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;


public interface PatientService {

    void addPatient(Patient patient) throws ParseException;

    void deletePatients(String startDate, String endDate);

    List<Patient> getPatientsByAge();

    Optional<Patient> getPatientById(Long id);
}
