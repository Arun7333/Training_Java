package org.java_based.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ValueAndProfile {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("side", "main");
        context.register(Config.class, Config2.class);
        context.refresh();

        Product product = context.getBean(Product.class);
        product.show();

        Product product1 = context.getBean(Product.class);
        product1.show();

        System.out.println(product1 + " " + product);
    }
}
