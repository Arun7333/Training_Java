package org.xml_based;

import org.models.Engine;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class TwoStrokes implements Engine {
    @Override
    public void start() {
        System.out.println("I am 2 strokes");
    }
}
