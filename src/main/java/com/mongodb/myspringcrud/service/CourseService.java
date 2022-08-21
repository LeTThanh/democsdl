package com.mongodb.myspringcrud.service;

import com.mongodb.myspringcrud.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getAllCourse(String keyword);

    Optional<Course> findCourseById(String courseId);

    void saveCourse(Course course);

    void deleteCourse(String courseId);
}
