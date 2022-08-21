package com.mongodb.myspringcrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.myspringcrud.entity.Student;
import com.mongodb.myspringcrud.repository.StudentRepository;
import com.mongodb.myspringcrud.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired private StudentRepository studentRepository;

  @Override
  public List<Student> getAllStudent(String keyword) {
    List<Student> students = new ArrayList<Student>();	
    if(keyword != null){
      List<Student> byLastName = studentRepository.findStudentByLastNameIsContainingIgnoreCase(keyword);
      List<Student> byFirstName = studentRepository.findStudentByFirstNameIsContainingIgnoreCase(keyword);
      List<Student> byEmail = studentRepository.findStudentByEmailIsContainingIgnoreCase(keyword);
      List<Student> byPhoneNumber = studentRepository.findStudentByPhoneNumberIsContainingIgnoreCase(keyword);
      for (Student student: byLastName){
      students.add(student);
      }
      for (Student student: byFirstName){
      students.add(student);
      }
      for (Student student: byEmail){
      students.add(student);
      }
      for (Student student: byPhoneNumber){
      students.add(student);
      }
    }else{
      students = (List<Student>)studentRepository.findAll();
    }
    return students;
  }

  @Override
  public void saveStudent(Student student) {
    studentRepository.save(student);
    
  }

  @Override
  public void deleteStudent(String id) {
    studentRepository.deleteById(id);
    
  }

  @Override
  public Optional<Student> findStudentById(String id) {
    return studentRepository.findById(id);
  }
}
