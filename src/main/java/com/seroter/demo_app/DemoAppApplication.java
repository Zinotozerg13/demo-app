package com.seroter.demo_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.seroter.demo_app.Student.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@SpringBootApplication
public class DemoAppApplication {
		public static void main(String[] args) {
			SpringApplication.run(DemoAppApplication.class, args);
		}
}
