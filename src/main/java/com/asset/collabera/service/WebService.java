package com.asset.collabera.service;

import com.asset.collabera.entity.Staff;
import com.asset.collabera.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

@Service
public class WebService {

    @Autowired
    StaffRepository staffRepository;

    public void saveStaff(Staff staff) {
        staffRepository.save(staff);
    }

    public Staff verifyStaff(String email, String password) {

        if(staffRepository.findByEmail(email).isPresent()) {
            Staff sStaff = staffRepository.findByEmail(email).get();
            return sStaff;
        }
        return null;
    }
}
