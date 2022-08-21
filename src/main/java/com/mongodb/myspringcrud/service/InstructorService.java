package com.mongodb.myspringcrud.service;

import com.mongodb.myspringcrud.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    List<Instructor> getAllInstructor(String keyword);

    Optional<Instructor> findInstructorById(String instructorId);

    void saveInstructor(Instructor instructor);

    void deleteInstructor(String instructorId);
}
