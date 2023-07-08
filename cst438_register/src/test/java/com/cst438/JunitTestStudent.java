package com.cst438;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.cst438.controller.StudentController;
import com.cst438.domain.Student;
import com.cst438.domain.StudentRepository;

@RunWith(MockitoJUnitRunner.class)
public class JunitTestStudent {

    @Mock
    private StudentRepository srepo;

    @InjectMocks
    private StudentController stuControl;

    @Test
    public void testAddStu() throws Exception {

        Student samp = new Student();
        samp.setEmail("ex@test.com");
        samp.setName("sam");
        samp.setStatusCode(0);
        samp.setStatus("No Hold");

        Mockito.when(srepo.save(samp)).thenReturn(samp);

        ResponseEntity<Student> savedStudent = stuControl.addStudent(samp);

        Mockito.verify(srepo).save(samp);

        assertEquals(samp, savedStudent.getBody());
    }
}