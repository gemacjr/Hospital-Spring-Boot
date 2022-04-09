package com.rocktech.hospital.service;

import com.rocktech.hospital.model.Staff;
import com.rocktech.hospital.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public boolean isUUIDValid(String uuid) {
        Staff staff = staffRepository.findStaffByUuid(uuid);
        return uuid.equals(staff.getUuid());
    }

    @Override
    public void addStaff(Staff staff) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd");
        String staffUuid = UUID.randomUUID().toString();
        staff.setUuid(staffUuid);
        staff.setRegistrationDate(formatter.parse(formatter.format(new Date())));
        staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(Staff staff, Long staffId) {
        Staff existingData = staffRepository.getById(staffId);
        if (staff.getName() != null && staff.getName().trim().length() > 1)
            existingData.setName(staff.getName());
        staffRepository.save(existingData);
        return existingData;
    }
}
