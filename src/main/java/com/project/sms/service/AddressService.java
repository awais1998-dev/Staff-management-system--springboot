package com.project.sms.service;

import com.project.sms.entity.Address;

import java.util.List;

public interface AddressService {

    public List<Address> getAllAddresses();
    public Address getAddressById(long id);
    public List<Address> getAddressesByStaffId(long staffId);
    public Address saveAddress(long staffId, Address address);
    public Address updateAddress(long id, Address address);
    public void deleteAddress(long id);
}
