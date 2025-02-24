package org.dao_practice;

public class User {
    int id, mark;
    String name, email;

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setMark(int mark){
        this.mark = mark;
    }

    @Override
    public String toString(){
        return "[" + id + ", " + name + ", " + email + ", " + mark + "]";
    }
}
