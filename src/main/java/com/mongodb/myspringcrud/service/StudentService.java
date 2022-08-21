package com.mongodb.myspringcrud.service;


import java.util.List;
import java.util.Optional;

import com.mongodb.myspringcrud.entity.Student;

public interface StudentService {
  List<Student> getAllStudent(String name);

  void saveStudent(Student student);

  void deleteStudent(String id);

  Optional<Student> findStudentById(String id);
}
