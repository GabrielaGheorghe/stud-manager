package com.university.studmanager.rest;

import com.university.studmanager.DTOs.StudentDTO;
import com.university.studmanager.domain.Student;
import com.university.studmanager.exceptions.StudentAlreadyExistsException;
import com.university.studmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody StudentDTO studentDTO) throws StudentAlreadyExistsException {
        return this.studentService.addStudent(studentDTO);
    }

    @PutMapping("/edit")
    public Student editStudent(@RequestBody StudentDTO student) {
        return studentService.editStudent(student);
    }

    @GetMapping()
    public List<Student> getAllStudenti() {
        return studentService.getAllStudenti();
    }

    @GetMapping("/get")
    public Student getStudentById(@RequestParam(name = "id") Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete")
    public void deleteStudentById(@RequestParam(name = "id") Long id) {
        studentService.deleteStudentById(id);
    }
}
