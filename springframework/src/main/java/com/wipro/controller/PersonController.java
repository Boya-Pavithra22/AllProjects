package com.wipro.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import com.wipro.dao.*;
import com.wipro.model.*;

public class PersonController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("personContext.xml");
        PersonDao dao = (PersonDao) context.getBean(PersonDao.class);

        List<person> people = dao.getAllPersons();
        for (person person : people) {
            System.out.println(person.getId() + " | " + person.getFirstName() + " " + person.getLastName() + " | Age: " + person.getAge());
        }
    }
}
