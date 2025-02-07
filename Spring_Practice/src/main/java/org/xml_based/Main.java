package org.xml_based;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Main {
    public Car car;
    public Bike bike;

    public Main(Car car, Bike bike) {
        this.car = car;
        this.bike = bike;
    }

//    public void setCar(Car car){
//        this.car = car;
//    }
//
//    public void setBike(Bike bike) {
//        this.bike = bike;
//    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Main main = (Main)context.getBean("main");
        main.startCar();
        main.bike.start();

        Object obj = (Object)context.getBean("object");
        System.out.println(obj.getName());
    }

    public void startCar(){
        car.start();
    }
}