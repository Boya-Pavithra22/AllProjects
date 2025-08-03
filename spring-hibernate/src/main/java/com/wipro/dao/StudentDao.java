package com.wipro.dao;

import com.wipro.model.Student;
import java.util.List;

public interface StudentDao {
    void save(Student student);
    List<Student> getAll();
}
