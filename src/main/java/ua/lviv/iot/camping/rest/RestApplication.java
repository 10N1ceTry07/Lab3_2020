package ua.lviv.iot.camping.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "ua.lviv.iot.camping.rest.restApplication.dataaccess", 
                 "ua.lviv.iot.camping.rest.restApplication.bussiness",
                 "ua.lviv.iot.camping.rest.restApplication.controller" 
               })
@EnableJpaRepositories({ "ua.lviv.iot.camping.rest.restApplication.dataaccess" })
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}