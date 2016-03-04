package com.atm.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main class to startup the application using tomcat embebed if you want a war please generate it with maven mvn package
 * do not forget to add this feature "<packaging>war</packaging>" on pom file currently is commented
 * 
 * @author fduarte
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.atm")
@EnableJpaRepositories("com.atm.domain.repository")
@EntityScan("com.atm.domain") 
@ImportResource({"classpath:/META-INF/atm-webapp-integration.xml"})
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}