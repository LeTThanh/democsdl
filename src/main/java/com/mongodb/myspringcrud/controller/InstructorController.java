package com.mongodb.myspringcrud.controller;

import com.mongodb.myspringcrud.entity.Instructor;
import com.mongodb.myspringcrud.entity.Student;
import com.mongodb.myspringcrud.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @RequestMapping("/")
    public String index(Model model, @Param("keyword") String keyword) {
        List<Instructor> instructors = instructorService.getAllInstructor(keyword);
        model.addAttribute("keyword", keyword);
        model.addAttribute("instructors", instructors);

        return "instructor";
    }

    @RequestMapping(value = "add")
    public String addInstructor(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "addInstructor.html";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editInstructor(@RequestParam("id") String instructorId, Model model) {
        Optional<Instructor> instructorEdit = instructorService.findInstructorById(instructorId);
        instructorEdit.ifPresent(instructor -> model.addAttribute("instructor", instructor));
        return "editInstructor.html";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Instructor instructor) {
        instructorService.saveInstructor(instructor);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteInstructor(@RequestParam("id") String instructorId, Model model) {
        instructorService.deleteInstructor(instructorId);
        return "testchart.html";
    }
}
