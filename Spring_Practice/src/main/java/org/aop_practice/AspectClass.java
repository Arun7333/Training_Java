package org.aop_practice;

import org.springframework.stereotype.Component;

@Component

public class AspectClass {

    public void insertKey(){
        System.out.println("Key inserted!");
    }

    public void removeKey(){
        System.out.println("Key removed!");
    }
}
