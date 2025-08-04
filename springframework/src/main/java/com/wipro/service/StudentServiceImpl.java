package com.wipro.service;

import com.wipro.dao.StudentDao;
import com.wipro.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDAO;

    @Transactional
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Transactional(readOnly = true)
    public List<Student> getAll() {
        return studentDAO.getAll();
    }
}

