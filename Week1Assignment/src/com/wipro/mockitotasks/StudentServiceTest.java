package com.wipro.mockitotasks;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;

class Student {
    private int id;
    private String name;
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
interface StudentRepository {
    Optional<Student> findById(int id);
}

class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public String getStudentById(int id) {
        return repository.findById(id)
                         .map(Student::getName)
                         .orElse("Student not found");
    }
}



public class StudentServiceTest {

	@Test
    public void testGetStudentByIdReturnsExpectedName() {

        StudentRepository mockRepo = mock(StudentRepository.class);
        Student dummyStudent = new Student(1, "Satya Sai");

        when(mockRepo.findById(1)).thenReturn(Optional.of(dummyStudent));

        StudentService service = new StudentService(mockRepo);


        String result = service.getStudentById(1);


        assertEquals("Satya Sai", result);


        verify(mockRepo, times(1)).findById(1);
    }
}