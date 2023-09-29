package com.project.sms.repository;

import com.project.sms.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    public List<Address> findByStaffId(long staffId);
}
