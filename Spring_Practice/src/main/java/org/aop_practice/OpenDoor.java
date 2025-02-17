package org.aop_practice;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Component
public class OpenDoor implements Door{

    OpenDoor(){}

    public void openTheDoor(){
        System.out.println("The Door is opened!");
    }

    @Override
    public void call() {
        openTheDoor();
    }
}
