package org.aop_practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AOP_Demo {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config_aop.xml");

        OpenDoor openDoor = context.getBean(OpenDoor.class);
        System.out.println(openDoor.getClass().getName());
        openDoor.openTheDoor();

        for(Class cls : openDoor.getClass().getInterfaces()){
            System.out.println(cls.getName());
        }

        System.out.println("_______________");
        for(Class cls : openDoor.getClass().getClasses()){
            System.out.println(cls.getName());
        }

        System.out.println(openDoor.getClass().getSuperclass().getName());

        System.out.println("_______________");
        for(Method method : openDoor.getClass().getDeclaredMethods()){
            System.out.println(method.getName());
        }
    }

    private static byte[] getClassBytes(Class<?> clazz) {
        try {
            ClassLoader classLoader = clazz.getClassLoader();
            String className = clazz.getName().replace('.', '/') + ".class";
            return Files.readAllBytes(Paths.get(classLoader.getResource(className).toURI()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to get class bytes", e);
        }
    }
}
