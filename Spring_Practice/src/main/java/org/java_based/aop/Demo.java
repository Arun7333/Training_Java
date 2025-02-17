package org.java_based.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        OpenDoor openDoor = context.getBean(OpenDoor.class);
        openDoor.openDoorWithKey(100);
        System.out.println("______________________________");
        openDoor.throwException(0);
    }
}
