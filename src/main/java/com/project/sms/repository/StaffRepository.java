package com.project.sms.repository;

import com.project.sms.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Long> {
}
