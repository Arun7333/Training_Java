package org.transaction_practise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;
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
    private TransactionTemplate template;

    @Autowired
    private PlatformTransactionManager transactionManager;

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


    public void addData(StuData stuData, DeptData deptData){
//        template.execute(status -> {
//            try {
//                self.addDepartment(deptData);
//                self.addStudent(stuData);
//                int a = 10 / 0;
//                Thread.sleep(6000);
//                System.out.println("write committed!");
//            } catch (Exception e) {
//                status.setRollbackOnly();
//            }
//
//            return 0;
//        });

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            self.addDepartment(deptData);
            Object savePoint = status.createSavepoint();
            try {
                int a = 10 / 0;
                self.addStudent(stuData);
            }
            catch(Exception e){
                status.rollbackToSavepoint(savePoint);
            }
            System.out.println("write committed!");
            transactionManager.commit(status);
        } catch (Exception e) {
            status.setRollbackOnly();
        }
    }

    @Transactional
    public void clearTables(){
        studentRepository.clearTables();
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public Student getSudent(int id){
        return studentRepository.readStudent(id);
    }
}
