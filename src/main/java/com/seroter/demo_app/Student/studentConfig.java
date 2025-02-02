package com.seroter.demo_app.Student;

import com.seroter.demo_app.Student.studentRepostiory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentConfig {

    @Bean
    CommandLineRunner commandLineRunner(studentRepostiory repository) {
        return args -> {
            student mariam = new student(
                    "Ronish",
                    "ron.raanjit@gmail.com",
                    LocalDate.of(2004, Month.FEBRUARY, 21)
            );
            student pranish = new student(
                    "Pranish",
                    "pra.raanjit@gmail.com",

                    LocalDate.of(2003, Month.FEBRUARY, 5)
            );
            repository.saveAll(List.of(mariam, pranish));
        };
    }
}
