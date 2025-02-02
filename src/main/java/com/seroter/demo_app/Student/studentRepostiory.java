package com.seroter.demo_app.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface studentRepostiory extends JpaRepository<student,Long> {
    //@Query("SELECT s FROM student s where s.email=?1")
Optional<student> findStudentByEmail(String email);
}
