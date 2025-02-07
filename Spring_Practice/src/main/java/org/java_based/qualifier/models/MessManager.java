package org.java_based.qualifier.models;

import org.java_based.qualifier.annotations.ManagerQualifier;
import org.java_based.qualifier.annotations.Mess;
import org.java_based.qualifier.enums.ManagerConstants;
import org.springframework.stereotype.Component;

@Component
@ManagerQualifier(type = ManagerConstants.Mess)
public class MessManager implements Manager{
    @Override
    public void manage() {
        System.out.println("Mess Manager");
    }
}
