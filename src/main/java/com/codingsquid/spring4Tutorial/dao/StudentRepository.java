package com.codingsquid.spring4Tutorial.dao;

import com.codingsquid.spring4Tutorial.model.Student;
import com.codingsquid.spring4Tutorial.rest_controller.command.StudentCommand;

public interface StudentRepository {

    Student findStudentByName(String name);
    long addStudent(StudentCommand student);

}
