package com.rocktech.hospital.controller;

import com.rocktech.hospital.model.Staff;
import com.rocktech.hospital.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("api/staff/")
public class HospitalController {

    @Autowired
    private StaffService staffService;

    @PostMapping("add-staff")
    public void addStaff(@RequestBody Staff staff) throws ParseException {
        staffService.addStaff(staff);
    }

    @PutMapping("update-staff/{staffId}")
    public Staff updateStaff(@RequestBody Staff staff, @PathVariable("staffId") Long staffId){
        return staffService.updateStaff(staff, staffId);
    }
}
