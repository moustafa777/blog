package com.mum.ea.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages="com.mum.ea")
<<<<<<< HEAD
@EntityScan(basePackages="com.mum.ea")
@EnableJpaRepositories(basePackages="com.mum.ea.dao")
=======
@EntityScan(basePackages = {"com.mum.ea.entities"}) 
>>>>>>> 850a4a74050218c22da8907b9e85aae738e07b34
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
}
