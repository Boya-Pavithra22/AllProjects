package com.wipro.service;

import com.wipro.model.Student;
import java.util.*;


public interface StudentService {
    void save(Student student);
    List<Student> getAll();
}

