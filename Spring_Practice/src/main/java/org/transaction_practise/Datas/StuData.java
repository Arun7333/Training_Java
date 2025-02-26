package org.transaction_practise.Datas;

public class StuData {
    private int stuId;
    private String stuName;
    private int deptId;


    public StuData(int stuId, String stuName, int deptId) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.deptId = deptId;
    }

    public int getStuId() {
        return stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
