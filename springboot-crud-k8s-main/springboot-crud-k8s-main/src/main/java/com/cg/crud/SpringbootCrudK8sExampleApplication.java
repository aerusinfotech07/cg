package com.cg.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootCrudK8sExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudK8sExampleApplication.class, args);
	}

}
