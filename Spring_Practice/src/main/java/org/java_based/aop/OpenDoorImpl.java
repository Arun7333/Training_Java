package org.java_based.aop;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class OpenDoorImpl implements OpenDoor{

    @Override
    public int openDoorWithKey(int num) {
        System.out.println("Door opened with key.....");
        return 1000;
    }

    @Override
    public void openDoorWithPass() {
        System.out.println("Door opened with Pass.....");
    }

    @Override
    public int openAndReturn() {
        System.out.println("Door opened And Returned.....");
        return 0;
    }

    @Override
    public void openAround() {
        System.out.println("Door opened Around.....");
    }

    @Override
    public void throwException(int num) {

        if(num == 0){
            System.out.println("Door opened with Exception.....");
            throw new ArithmeticException();
        }
        System.out.println("Door opened without Exception.....");
    }
}
