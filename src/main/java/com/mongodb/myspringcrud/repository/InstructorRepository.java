package com.mongodb.myspringcrud.repository;

import com.mongodb.myspringcrud.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Long> {
    List<Instructor> findInstructorByNameIsContainingIgnoreCase(String keyword);

    List<Instructor> findInstructorByEmailIsContainingIgnoreCase(String keyword);

    Optional<Instructor> findById(String instructorId);

    void deleteById(String instructorId);
}
