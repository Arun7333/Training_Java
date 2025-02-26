package org.transaction_practise.Datas;

public class Data {
    private StuData stuData;
    private DeptData deptData;

    public Data(StuData stuData, DeptData deptData) {
        this.stuData = stuData;
        this.deptData = deptData;
    }

    public StuData getStuData() {
        return stuData;
    }

    public DeptData getDeptData() {
        return deptData;
    }
}
