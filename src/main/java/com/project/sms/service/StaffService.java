package com.project.sms.service;

import com.project.sms.entity.Staff;

import java.util.List;

public interface StaffService {

    public List<Staff> getAllStaff();
    public Staff getStaffById(long id);
    public Staff saveStaff(Staff staff);
    public Staff updateStaff(long id, Staff staff);
    public void deleteStaff(long id);
}
