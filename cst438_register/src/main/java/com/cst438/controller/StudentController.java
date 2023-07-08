package com.cst438.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cst438.domain.ScheduleDTO;
import com.cst438.domain.Student;
import com.cst438.domain.StudentRepository;
import com.google.common.base.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository srepo;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        // Check if the student email already exists
        if (srepo.findByEmail(student.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student email already exists.");
        }

        // Add the student to the system
        srepo.save(student);
        //return student;
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
    
    @PutMapping("/{id}/no-hold")
    public Student putStudentHold(@PathVariable("id") int student_id) throws Exception {
    	// looking for the student
    	java.util.Optional<Student> optionalStudent = srepo.findById(student_id);
    	// if not exist, throw error.
    	if(!optionalStudent.isPresent()) {
    		throw new Exception("Student not registered");
    	}
    	
    	Student student = optionalStudent.get();
    	student.setStatus("Hold");
    	student.setStatusCode(1);
    	//Student currentStudent = srepo.save(student);
		//return currentStudent;
    	
    	return srepo.save(student);
    	
    }
    
    @PutMapping("/{id}/release-hold")
    public Student setToRelease(@PathVariable("id") int student_id) throws Exception {
    	java.util.Optional<Student> optionalStudent = srepo.findById(student_id);
    	if (!optionalStudent.isPresent()) {
    		throw new Exception ("Not Found");
    	}
    	Student student = optionalStudent.get();
    	
    	student.setStatus("Release");
    	student.setStatusCode(0);
    	
    	return srepo.save(student);
    }
    public StudentRepository getRepo() {
    	return srepo;
    }
}





//@RestController
//public class StudentController {
//
//	@PostMapping("/addStudent")
//	public void addCourse( @RequestBody Student student  ) { 
//
//	}	
//}
//
