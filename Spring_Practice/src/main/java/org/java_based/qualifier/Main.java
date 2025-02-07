package org.java_based.qualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.java_based.qualifier");
        context.refresh();

        Management management = context.getBean(Management.class);
        management.display();
    }
}
