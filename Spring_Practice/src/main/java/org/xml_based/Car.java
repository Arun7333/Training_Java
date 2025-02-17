package org.xml_based;

import org.models.Engine;
import org.models.Vehicle;



public class Car implements Vehicle {
    private Engine engine;
    private String name;
    public int id;

    Car(Engine engine, String name, int id){
        this.engine = engine;
        this.name = name;
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public Engine getEngine(){
        return engine;
    }

    public void setEngine(Engine engine){
        this.engine = engine;
    }

    public static Integer getId(){
        return 100;
    }

    @Override
    public void start() {
        System.out.println(name + " car is starting");
        engine.start();
    }
}
