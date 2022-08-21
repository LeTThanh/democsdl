package com.mongodb.myspringcrud.controller;

import com.mongodb.myspringcrud.entity.Course;
import com.mongodb.myspringcrud.entity.Student;
import com.mongodb.myspringcrud.repository.CourseRepository;
import com.mongodb.myspringcrud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Controller
public class CoursesController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/")
    public String index(Model model, @Param("keyword") String keyword) {
        List<Course> courses = courseService.getAllCourse(keyword);
        model.addAttribute("keyword", keyword);
        model.addAttribute("courses", courses);

        return "course";
    }

    @RequestMapping(value = "add")
    public String addCourse(Model model) {
        model.addAttribute("course", new Course());
        return "addCourse.html";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCourse(@RequestParam("id") String courseId, Model model) {
        Optional<Course> courseEdit = courseService.findCourseById(courseId);
        courseEdit.ifPresent(course -> model.addAttribute("course", course));
        return "editCourse.html";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Course course) {
        courseService.saveCourse(course);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCourse(@RequestParam("id") String courseId, Model model) {
        courseService.deleteCourse(courseId);
        return "testchart.html";
    }
}

