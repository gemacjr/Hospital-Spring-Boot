package com.rocktech.hospital.service;

import com.rocktech.hospital.model.Staff;

import java.text.ParseException;


public interface StaffService {

    boolean isUUIDValid(String uuid);

    void addStaff(Staff staff) throws ParseException;

    Staff updateStaff(Staff staff, Long staffId);
}
