package org.xml_based;

public class Object_Factory {

    public static Object getObject(String name){
        return Object.newInstance(name);
    }
}
