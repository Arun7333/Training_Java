package org.transaction_practise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.transaction_practise.Datas.Data;
import org.transaction_practise.Datas.DeptData;
import org.transaction_practise.Datas.StuData;
import org.transaction_practise.Entities.Student;
import org.transaction_practise.Transaction_Demo;
import org.transaction_practise.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService self;

    @Transactional
    public void addStudent(StuData data){
        studentRepository.addStudent(data);
    }

    @Transactional
    public void addDepartment(DeptData data){
        studentRepository.addDepartment(data);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addData(StuData stuData, DeptData deptData){
        self.addDepartment(deptData);
        self.addStudent(stuData);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("write committed!");
    }

    public void clearTables(){
        studentRepository.clearTables();
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public Student getSudent(int id){
        return studentRepository.readStudent(id);
    }
}
