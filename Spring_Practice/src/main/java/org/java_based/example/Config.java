package org.java_based.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.xml_based.Bike;

@Configuration
@PropertySource("classpath:price.properties")
@Profile("main")
public class Config {

    @Autowired
    Environment env;

    @Bean
    public Bike getBike(){
        return new Bike();
    }

    @Bean
    @Scope("prototype")
    public Product getProduct(){
        return new Product("bike", env.getProperty("bike", Integer.class));
    }
}
