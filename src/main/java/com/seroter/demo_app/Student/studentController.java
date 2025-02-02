package com.seroter.demo_app.Student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class studentController {
    private final studentService studentService;

    public studentController(studentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public String registerNewStudent(@RequestBody student student) {
        return studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId) {
        return studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId, @RequestBody student updatedStudent) {
        return studentService.updateStudent(studentId, updatedStudent);
    }

}