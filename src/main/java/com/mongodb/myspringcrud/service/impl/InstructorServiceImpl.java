package com.mongodb.myspringcrud.service.impl;

import com.mongodb.myspringcrud.entity.Instructor;
import com.mongodb.myspringcrud.entity.Student;
import com.mongodb.myspringcrud.repository.InstructorRepository;
import com.mongodb.myspringcrud.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;
    @Override
    public List<Instructor> getAllInstructor(String keyword) {
        List<Instructor> instructors = new ArrayList<Instructor>();
        if(keyword != null){
            List<Instructor> byName = instructorRepository.findInstructorByNameIsContainingIgnoreCase(keyword);
            List<Instructor> byEmail = instructorRepository.findInstructorByEmailIsContainingIgnoreCase(keyword);
            for (Instructor instructor: byName){
                instructors.add(instructor);
            }
            for (Instructor instructor: byEmail){
                instructors.add(instructor);
            }
        }else{
            instructors = (List<Instructor>)instructorRepository.findAll();
        }
        return instructors;
    }

    @Override
    public Optional<Instructor> findInstructorById(String instructorId) {
        return instructorRepository.findById(instructorId);
    }

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructor(String instructorId) {
        instructorRepository.deleteById(instructorId);
    }
}
