package com.devnest.user.service.impl;
import com.devnest.database.user.repository.TeacherRepository;
import com.devnest.user.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
     public  final TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean delete(Long Id) {
        repository.deleteById(Id);
        return true;
    }


}
