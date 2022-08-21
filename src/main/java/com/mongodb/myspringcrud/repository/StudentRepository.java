package com.mongodb.myspringcrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.myspringcrud.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Optional<Student> findById(String id);

    void deleteById(String id);

    List<Student> findStudentByLastNameIsContainingIgnoreCase(String name);
    List<Student> findStudentByFirstNameIsContainingIgnoreCase(String name);
    List<Student> findStudentByEmailIsContainingIgnoreCase(String name);
    List<Student> findStudentByPhoneNumberIsContainingIgnoreCase(String name);
    
    List<Student> findStudentByGpaIsBetween(Double min, Double max);
}
