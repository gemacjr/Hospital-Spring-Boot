package com.rocktech.hospital.service;

import com.rocktech.hospital.model.Patient;
import com.rocktech.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void addPatient(Patient patient) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd");
        patient.setLastVisitDate(formatter.parse(formatter.format(new Date())));
        patientRepository.save(patient);
    }

    @Override
    public void deletePatients(String startDate, String endDate) {
        patientRepository.deletePatientByDateRange(startDate, endDate);
    }

    @Override
    public List<Patient> getPatientsByAge() {
        return patientRepository.getPatientByAge();
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
}
