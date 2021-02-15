package com.grupo12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.grupo12"})
@EnableJpaRepositories(basePackages = {"com.grupo12"})
@EntityScan(basePackages = {"com.grupo12"}) 
public class LocadoraApplication {
  public static void main(String[] args) {
    SpringApplication.run(LocadoraApplication.class, args);
  }
}
