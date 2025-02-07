package org.java_based.qualifier.models;

import org.java_based.qualifier.annotations.ManagerQualifier;
import org.java_based.qualifier.annotations.Transport;
import org.java_based.qualifier.enums.ManagerConstants;
import org.springframework.stereotype.Component;

@Component
@ManagerQualifier(type = ManagerConstants.Transport)
public class TransportManager implements Manager{
    @Override
    public void manage() {
        System.out.println("Transport manager");
    }
}
