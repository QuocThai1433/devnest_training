package com.devnest.user.service.impl;

import com.devnest.user.repository.StudentRepository;
import com.devnest.user.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
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
