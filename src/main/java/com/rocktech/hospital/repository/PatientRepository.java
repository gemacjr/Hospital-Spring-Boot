package com.rocktech.hospital.repository;

import com.rocktech.hospital.model.Patient;
import com.rocktech.hospital.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("delete from Patient p where p.lastVisitDate=?1 and p.lastVisitDate=?2")
    void deletePatientByDateRange(String startDate, String endDate);

    @Query("select p from Patient p where p.age > 1")
    List<Patient> getPatientByAge();

}
