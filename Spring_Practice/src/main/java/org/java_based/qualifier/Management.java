package org.java_based.qualifier;

import org.java_based.qualifier.annotations.ManagerQualifier;
import org.java_based.qualifier.enums.ManagerConstants;
import org.java_based.qualifier.models.Manager;
import org.springframework.stereotype.Component;

@Component
public class Management {
    private Manager mess;
    private Manager transport;
    private Manager event;
    private Manager security;

    Management(
            @ManagerQualifier(type = ManagerConstants.Mess) Manager mess,
            @ManagerQualifier(type = ManagerConstants.Transport) Manager trans,
            @ManagerQualifier(type = ManagerConstants.Event) Manager event,
            @ManagerQualifier(type = ManagerConstants.Security) Manager sec
    ){

        System.out.println(ManagerConstants.valueOf("Event"));
        this.mess = mess;
        transport = trans;
        this.event = event;
        security = sec;
    }

    public void display(){
        mess.manage();
        transport.manage();
        event.manage();
        security.manage();
    }
}
