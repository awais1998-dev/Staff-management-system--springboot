package com.project.sms.service;

import com.project.sms.entity.Staff;
import com.project.sms.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getStaffById(long id) {
        return staffRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Staff not found")
        );
    }

    @Override
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(long id, Staff staff) {
        Staff existingStaff = staffRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Staff not found")
        );
        existingStaff.setName(staff.getName());
        existingStaff.setEmail(staff.getEmail());
        existingStaff.setPhone(staff.getPhone());
        return staffRepository.save(existingStaff);
    }

    @Override
    public void deleteStaff(long id) {
        Staff staff = staffRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Staff not found")
        );
        staffRepository.delete(staff);
    }
}
