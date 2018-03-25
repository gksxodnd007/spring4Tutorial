package com.codingsquid.spring4Tutorial.rest_controller;

import com.codingsquid.spring4Tutorial.dao.StudentRepositoryImpl;
import com.codingsquid.spring4Tutorial.model.Mentor;
import com.codingsquid.spring4Tutorial.model.Student;
import com.codingsquid.spring4Tutorial.rest_controller.command.StudentCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.print.attribute.standard.Severity;
import javax.servlet.ServletContext;
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
    public Student restAPITest(@RequestParam("name") String name, ServletContext sc) {
        WebApplicationContext webCtx = WebApplicationContextUtils.getWebApplicationContext(sc);
        System.out.println(webCtx.getServletContext().getMimeType("application/json"));
        System.out.println(webCtx.getBean("mentor", Mentor.class).getMentee());
        return studentRepositoryImpl.findStudentByName(name);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public void addStudent(StudentCommand command, HttpServletResponse response) throws IOException {
        studentRepositoryImpl.addStudent(command);
        response.sendRedirect("/page/getStudent?name=" + command.getName());
    }

}
