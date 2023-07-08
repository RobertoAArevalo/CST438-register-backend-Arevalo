package com.cst438;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import com.cst438.controller.StudentController;
import com.cst438.domain.Student;
import com.cst438.domain.StudentRepository;

@SpringBootTest
public class JunitTestHold {

    @Mock
    private StudentRepository srepo;

    @InjectMocks
    private StudentController sCont;

    @Test
    public void changeHold() throws Exception {
        Student samp = new Student();
        samp.setEmail("ex@test.com");
        samp.setName("samp");
        samp.setStatusCode(0);
        samp.setStatus("Active");
        Mockito.when(srepo.findByEmail(samp.getEmail())).thenReturn(null);
        Mockito.when(srepo.save(samp)).thenReturn(samp);
        ResponseEntity<Student> savedStudent = sCont.addStudent(samp);
        assertEquals(samp, savedStudent.getBody());
        if (savedStudent.getBody() != null) {
            assertEquals("Active", savedStudent.getBody().getStatus(), "Should be Active");
        } else {
            // Handle the case where the body is null
            assertEquals("Active", null, "Expected status: Active");
        }
    }
    
    @Test
    public void checkHold() throws Exception {
        Student samp = new Student();
        samp.setEmail("ex@test.com");
        samp.setName("samp");
        samp.setStatusCode(1);
        samp.setStatus("On Hold");
        Mockito.when(srepo.findByEmail(samp.getEmail())).thenReturn(null);
        Mockito.when(srepo.save(samp)).thenReturn(samp);
        ResponseEntity<Student> savedStudent = sCont.addStudent(samp);
        assertEquals(samp, savedStudent.getBody());
        if (savedStudent.getBody() != null) {
            assertEquals("On Hold", savedStudent.getBody().getStatus(), "Should be On Hold");
        } else {
            assertEquals("On Hold", null, "Should be On Hold");
        }
    }

    @Test
    public void checkActive() throws Exception {
        Student samp = new Student();
        samp.setEmail("ex@test.com");
        samp.setName("samp");
        samp.setStatusCode(0);
        samp.setStatus("Active");

        Mockito.when(srepo.findByEmail(samp.getEmail())).thenReturn(null);
        Mockito.when(srepo.save(samp)).thenReturn(samp);

        ResponseEntity<Student> savedStudent = sCont.addStudent(samp);
        assertEquals(samp, savedStudent.getBody());
        if (savedStudent.getBody() != null) {
            assertEquals("Active", savedStudent.getBody().getStatus(), "Should be Active");
        } else {
            // Handle the case where the body is null
            assertEquals("Active", null, "Should be Active");
        }
    }
}