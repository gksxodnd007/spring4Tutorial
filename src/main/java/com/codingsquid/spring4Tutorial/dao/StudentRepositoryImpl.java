package com.codingsquid.spring4Tutorial.dao;

import com.codingsquid.spring4Tutorial.model.Student;
import com.codingsquid.spring4Tutorial.rest_controller.command.StudentCommand;
import org.apache.ibatis.session.SqlSession;

public class StudentRepositoryImpl implements StudentRepository {

    private SqlSession sqlSession;

    public StudentRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        System.out.println(sqlSession.toString());
    }

    @Override
    public Student findStudentByName(String name) {
        return sqlSession.selectOne("database.getStudentByName", name);
    }

    @Override
    public long addStudent(StudentCommand student) {
        return sqlSession.insert("database.addStudentOne", student);
    }

}
