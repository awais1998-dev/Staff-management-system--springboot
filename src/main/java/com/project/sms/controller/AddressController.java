package com.project.sms.controller;

import com.project.sms.entity.Address;
import com.project.sms.entity.Staff;
import com.project.sms.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddresses(){
        return new ResponseEntity<List<Address>>(addressService.getAllAddresses(), HttpStatus.OK);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable long id){
        return new ResponseEntity<Address>(addressService.getAddressById(id), HttpStatus.OK);
    }

    @GetMapping("/staff/{staffId}/address")
    public ResponseEntity<List<Address>> getAddressesByStaffId(@PathVariable long staffId){
        return new ResponseEntity<List<Address>>(addressService.getAddressesByStaffId(staffId), HttpStatus.OK);
    }

    @PostMapping("/staff/{staffId}/address")
    public ResponseEntity<Address> saveAddress(@PathVariable long staffId, @RequestBody Address address){
        return new ResponseEntity<Address>(addressService.saveAddress(staffId, address), HttpStatus.CREATED);
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable long id, @RequestBody Address address){
        return new ResponseEntity<Address>(addressService.updateAddress(id, address), HttpStatus.OK);
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable long id){
        addressService.deleteAddress(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
