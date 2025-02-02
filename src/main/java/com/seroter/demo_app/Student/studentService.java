package com.seroter.demo_app.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentService {
    private final studentRepostiory studentRepository;

    @Autowired
    public studentService(studentRepostiory studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getStudents() {
        return studentRepository.findAll();
    }

    public String addNewStudent(student student) {
        Optional<student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalArgumentException("Email taken");
        }
        studentRepository.save(student);
        return "Student registered successfully!";
    }
    public String deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist.");
        }
        studentRepository.deleteById(studentId);
        return "Student deleted successfully!";
    }
    public String updateStudent(Long studentId, student updatedStudent) {
        student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist."));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDob(updatedStudent.getDob());
        existingStudent.setAge(updatedStudent.getAge());

        studentRepository.save(existingStudent);
        return "Student updated successfully!";
    }

}
