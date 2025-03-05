package com.devnest.user.service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface StaffService {

    boolean delete (@PathVariable Long Id);

}
