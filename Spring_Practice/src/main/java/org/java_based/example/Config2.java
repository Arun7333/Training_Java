package org.java_based.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:price2.properties")
@Profile("side")
public class Config2 {

    @Autowired
    Environment env;

    @Bean
    @Scope("prototype")
    public Product getProduct(){
        String name = "car";
        int price = env.getProperty(name, Integer.class);

        return new Product(name, price);
    }

}
