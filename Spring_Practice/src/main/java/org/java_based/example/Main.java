package org.java_based.example;

import org.models.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Vehicle vehicle = context.getBean(Car.class);
        vehicle.start();
    }
}
