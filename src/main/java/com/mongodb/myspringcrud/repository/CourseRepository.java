package com.mongodb.myspringcrud.repository;

import com.mongodb.myspringcrud.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
    List<Course> findCourseByNameIsContainingIgnoreCase(String keyword);

    List<Course> findCourseByRatingsIsContainingIgnoreCase(String keyword);

    void deleteById(String courseId);

    Optional<Course> findById(String courseId);
}
