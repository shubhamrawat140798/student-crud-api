package com.student_crud_api.controller;

import com.student_crud_api.model.Student;
import com.student_crud_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    Student student;
    @Autowired
    StudentRepository studentRepository;
    @PostMapping(path="/addStudent")
    public @ResponseBody String addNewStudent (@RequestBody Student receivedStudent) {
        try {
            studentRepository.save(receivedStudent);
        }
        catch (Exception e){
            return e.toString();
        }
        return "Student is added";
    }
    @GetMapping(path = "/getStudentList")
    public @ResponseBody List<Student> getStudentList () {
        return studentRepository.findAll();
    }
    @PutMapping(path = "/updateStudent")
    public @ResponseBody String updateStudent (@RequestBody Student receivedStudent) {
        Student updationInRecords = studentRepository.getByRollNo(receivedStudent.getRollNo());
        if(receivedStudent.getMobileNumber()!= null){
            updationInRecords.setMobileNumber(receivedStudent.getMobileNumber());
        }
        if (receivedStudent.getName() != null){
            updationInRecords.setName(receivedStudent.getName());
        }
        if(receivedStudent.getAddress() != null){
            updationInRecords.setAddress(receivedStudent.getAddress());
        }
        studentRepository.save(updationInRecords);
        return "Student is Updated";
    }
    @DeleteMapping(path = "/deleteStudent")
    public @ResponseBody String deleteStudent (@RequestBody Student receivedStudent) {
        try {
            receivedStudent = studentRepository.getByRollNo(receivedStudent.getRollNo());
            studentRepository.delete(receivedStudent);
        }
        catch (Exception e){
            return e.toString();
        }
        return "Student is deleted";
    }
}
