package org.xml_based;

import org.models.Engine;
import org.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class Bike implements Vehicle {
    Engine engine;


    public void setEngine(Engine engine){
        this.engine = engine;
    }

    @Override
    public void start() {
        System.out.println("Bike is starting");
        engine.start();
    }
}
