package com.devnest.user.service.impl;

import com.devnest.user.repository.StudentRepository;
import com.devnest.user.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements TeacherService {
    public  final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;

    }


    @Override
    public boolean delete(Long Id) {
        repository.deleteById(Id);
        return true;
    }


}
