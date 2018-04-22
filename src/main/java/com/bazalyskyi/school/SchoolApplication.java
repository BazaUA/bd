package com.bazalyskyi.school;

import com.bazalyskyi.school.controller.HomeController;
import com.bazalyskyi.school.dao.SubjectDao;
import com.bazalyskyi.school.entity.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SchoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);


	}
}
