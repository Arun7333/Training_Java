package org.transaction_practise.Entities;

public class Student {
    private int id;
    private String name;
    private int deptId;

    public Student(){}

    public int getDeptId() {
        return deptId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}
