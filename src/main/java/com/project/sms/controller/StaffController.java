package com.project.sms.controller;

import com.project.sms.entity.Staff;
import com.project.sms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff(){
        return new ResponseEntity<List<Staff>>(staffService.getAllStaff(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable long id){
        return new ResponseEntity<Staff>(staffService.getStaffById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Staff> saveStaff(@RequestBody Staff staff){
        return new ResponseEntity<Staff>(staffService.saveStaff(staff), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable long id, @RequestBody Staff staff){
        return new ResponseEntity<Staff>(staffService.updateStaff(id, staff), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable long id){
        staffService.deleteStaff(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
