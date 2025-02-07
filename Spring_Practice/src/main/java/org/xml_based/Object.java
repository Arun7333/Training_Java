package org.xml_based;

public class Object{
    private String name;

    private Object(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static Object newInstance(String name){
        return new Object(name);
    }
}
