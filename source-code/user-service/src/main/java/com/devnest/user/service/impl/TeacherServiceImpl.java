package com.devnest.user.service.impl;
import com.devnest.user.repository.TeacherRepsitory;
import com.devnest.user.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
     public  final TeacherRepsitory repository;

    public TeacherServiceImpl(TeacherRepsitory repository) {
        this.repository = repository;
    }

    @Override
    public boolean delete(Long Id) {
        repository.deleteById(Id);
        return true;
    }


}
