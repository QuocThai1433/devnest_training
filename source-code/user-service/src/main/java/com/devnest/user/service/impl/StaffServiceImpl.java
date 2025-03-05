package com.devnest.user.service.impl;

import com.devnest.user.repository.StaffRepository;
import com.devnest.user.service.StaffService;
import com.devnest.user.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    public  final StaffRepository repository;

    public StaffServiceImpl(StaffRepository repository) {
        this.repository = repository;

    }


    @Override
    public boolean delete(Long Id) {
        repository.deleteById(Id);
        return true;
    }


}
