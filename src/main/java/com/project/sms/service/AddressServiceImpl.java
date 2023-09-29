package com.project.sms.service;

import com.project.sms.entity.Address;
import com.project.sms.entity.Staff;
import com.project.sms.repository.AddressRepository;
import com.project.sms.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(long id) {
        return addressRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Address not found")
        );
    }

    @Override
    public List<Address> getAddressesByStaffId(long staffId) {
        Staff staff = staffRepository.findById(staffId).orElseThrow(
                () -> new RuntimeException("Staff not found")
        );
        return addressRepository.findByStaffId(staffId);
    }

    @Override
    public Address saveAddress(long staffId, Address address) {
        Staff staff = staffRepository.findById(staffId).orElseThrow(
                () -> new RuntimeException("Staff not found")
        );
        address.setStaff(staff);
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(long id, Address address) {
        Address existingAddress = addressRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Address not found")
        );
        existingAddress.setStreet(address.getStreet());
        existingAddress.setCity(address.getCity());
        existingAddress.setZipCode(address.getZipCode());
        return address;
    }

    @Override
    public void deleteAddress(long id) {
        Address address = addressRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Address not found")
        );
        addressRepository.delete(address);
    }
}
