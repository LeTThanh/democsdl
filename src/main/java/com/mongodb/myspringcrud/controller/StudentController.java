package com.mongodb.myspringcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongodb.myspringcrud.entity.Student;
import com.mongodb.myspringcrud.repository.StudentRepository;
import com.mongodb.myspringcrud.service.StudentService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Controller
public class StudentController {
  @Autowired private StudentService studentService;
  @Autowired private StudentRepository StudentRepository;

  @RequestMapping("/")
  public String index(Model model, @Param("keyword") String keyword) {
    List<Student> students = studentService.getAllStudent(keyword);
    model.addAttribute("keyword", keyword);
    model.addAttribute("students", students);

    return "index";
  }

  @RequestMapping(value = "add")
  public String addStudent(Model model) {
    model.addAttribute("student", new Student());
    return "addStudent.html";
  }

  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public String editStudent(@RequestParam("id") String studentId, Model model) {
    Optional<Student> studentEdit = studentService.findStudentById(studentId);
    studentEdit.ifPresent(student -> model.addAttribute("student", student));
    return "editStudent.html";
  }

  @RequestMapping(value = "save", method = RequestMethod.POST)
  public String save(Student student) {
    studentService.saveStudent(student);
    return "redirect:/";
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public String deleteStudent(@RequestParam("id") String studentId, Model model) {
    studentService.deleteStudent(studentId);
    return "testchart.html";
  }

  @GetMapping("/chart")
  public String getPieChart(Model model) {
      List<Student> gradeA = StudentRepository.findStudentByGpaIsBetween(3.19, 4.01);
      List<Student> gradeB = StudentRepository.findStudentByGpaIsBetween(2.49, 3.19);
      List<Student> gradeC = StudentRepository.findStudentByGpaIsBetween(0.99, 2.49);
      List<Student> gradeD = StudentRepository.findStudentByGpaIsBetween(0.01, 0.99);
      Map<String, Integer> graphData = new TreeMap<>();
      graphData.put("Very good", gradeA.size());
      graphData.put("Good", gradeB.size());
      graphData.put("Average", gradeC.size());
      graphData.put("Below average", gradeD.size());
      model.addAttribute("chartData", graphData);
      return "chart.html";
  }

}
