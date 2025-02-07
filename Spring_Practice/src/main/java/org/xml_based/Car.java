package org.xml_based;

import org.models.Engine;
import org.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class Car implements Vehicle {
    private Engine engine;
    private String name;
    private int id;

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

    @Override
    public void start() {
        System.out.println(name + " car is starting");
        engine.start();
    }
}
