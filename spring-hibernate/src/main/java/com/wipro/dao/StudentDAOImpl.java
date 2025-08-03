package com.wipro.dao;

import com.wipro.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    public List<Student> getAll() {
        return sessionFactory.getCurrentSession()
                             .createQuery("from Student", Student.class)
                             .list();
    }
}
