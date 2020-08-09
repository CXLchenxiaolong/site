package com.site.webapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@MapperScan(basePackages = "com.site.service.mapper")
@ComponentScan(basePackages = {"com.site"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WebappApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebappApplication.class, args);
  }
}
