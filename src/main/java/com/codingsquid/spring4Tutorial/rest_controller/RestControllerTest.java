package com.codingsquid.spring4Tutorial.rest_controller;

import com.codingsquid.spring4Tutorial.dao.StudentRepositoryImpl;
import com.codingsquid.spring4Tutorial.model.Student;
import com.codingsquid.spring4Tutorial.rest_controller.command.StudentCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class RestControllerTest {

    private StudentRepositoryImpl studentRepositoryImpl;

    @Autowired
    public RestControllerTest(StudentRepositoryImpl studentRepositoryImpl) {
        this.studentRepositoryImpl = studentRepositoryImpl;
    }

    @RequestMapping(value = "/restControllerTest", method = RequestMethod.GET)
    public Student restAPITest(@RequestParam("name") String name) {
        return studentRepositoryImpl.findStudentByName(name);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public void addStudent(StudentCommand command, HttpServletResponse response) throws IOException {
        studentRepositoryImpl.addStudent(command);
        response.sendRedirect("/page/getStudent?name=" + command.getName());
    }

}
