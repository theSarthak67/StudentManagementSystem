package com.sarthak.app.dao;

import com.sarthak.app.model.Student;
import java.util.List;

public interface StudentDao {

    void addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    void updateStudent(Student student);

    void deleteStudent(int id);
}
