package org.java_based.aop;

import org.springframework.stereotype.Component;

@Component
public interface OpenDoor {
    public int openDoorWithKey(int num);

    public void openDoorWithPass();

    public int openAndReturn();

    public void openAround();

    public void throwException(int num);
}
