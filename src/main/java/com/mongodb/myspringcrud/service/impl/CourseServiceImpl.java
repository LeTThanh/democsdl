package com.mongodb.myspringcrud.service.impl;

import com.mongodb.myspringcrud.entity.Course;
import com.mongodb.myspringcrud.entity.Student;
import com.mongodb.myspringcrud.repository.CourseRepository;
import com.mongodb.myspringcrud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourse(String keyword) {
        List<Course> courses = new ArrayList<Course>();
        if(keyword != null){
            List<Course> byName = courseRepository.findCourseByNameIsContainingIgnoreCase(keyword);
            List<Course> byRating = courseRepository.findCourseByRatingsIsContainingIgnoreCase(keyword);

            for (Course course: byName){
                courses.add(course);
            }
            for (Course course: byRating){
                courses.add(course);
            }
        }else{
            courses = (List<Course>)courseRepository.findAll();
        }
        return courses;
    }

    @Override
    public Optional<Course> findCourseById(String courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(String courseId) {
        courseRepository.deleteById(courseId);
    }
}
