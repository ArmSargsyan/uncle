package com.example.emploee;

import com.example.emploee.model.ModelCompany;
import com.example.emploee.model.ModelEmployee;
import com.example.emploee.model.Role;
import com.example.emploee.repository.CompanyRepository;
import com.example.emploee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
    }

}
