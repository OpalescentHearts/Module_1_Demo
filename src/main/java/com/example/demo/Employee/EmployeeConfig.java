package com.example.demo.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
            Employee Amber = new Employee(
                    "Amber",
                    "Montgomery",
                    LocalDate.of(2004, Month.APRIL, 9),
                    "Plushies",
                    "Sushi"
            );
            Employee Angela = new Employee(
                    "Angela",
                    "Reeves",
                    LocalDate.of(2003, Month.JUNE,13 ),
                    "One Piece",
                    "Chocolate Cake"
            );
            repository.saveAll(
                    List.of(Amber, Angela)
            );
        };
    }
}
