package com.cst438;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

import com.cst438.controller.StudentController;

@ContextConfiguration(classes = {StudentController.class })
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest

public class JunitTestNewStudent {

}
