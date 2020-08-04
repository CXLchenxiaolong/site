package com.site.webapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = "com.site.service.mapper")
@ComponentScan(basePackages = { "com.site"})
@SpringBootApplication
public class WebappApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebappApplication.class, args);
  }
}
