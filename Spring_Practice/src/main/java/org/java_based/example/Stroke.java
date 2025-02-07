package org.java_based.example;

import org.models.Engine;
import org.springframework.stereotype.Component;

@Component
public class Stroke implements Engine {
    @Override
    public void start() {
        System.out.println("Strokes started..");
    }
}
