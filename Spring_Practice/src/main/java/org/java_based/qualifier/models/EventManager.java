package org.java_based.qualifier.models;


import org.java_based.qualifier.annotations.ManagerQualifier;
import org.java_based.qualifier.enums.ManagerConstants;
import org.springframework.stereotype.Component;

@Component
@ManagerQualifier(type = ManagerConstants.Event)
public class EventManager implements Manager{
    @Override
    public void manage() {
        System.out.println("Event Manager");
    }
}
