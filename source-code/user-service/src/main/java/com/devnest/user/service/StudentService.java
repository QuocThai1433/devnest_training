package com.devnest.user.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface StudentService {

    boolean delete (@PathVariable Long Id);

}
