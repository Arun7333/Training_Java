package org.transaction_practise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.transaction_practise.Datas.DeptData;
import org.transaction_practise.Datas.StuData;
import org.transaction_practise.Entities.Student;
import org.transaction_practise.configuration.Config;
import org.transaction_practise.repositories.StudentRepository;
import org.transaction_practise.services.StudentService;

@Component
public class Transaction_Demo {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        StudentService service = context.getBean(StudentService.class);

//        clearTables(service);
//        addData(service);
//        getStudent(1, service);

        runByThreads(service);
    }

    public static void runByThreads(StudentService service){
        Thread writeThread = new Thread(() ->{
            clearTables(service);
            addData(service);
        });

        Thread readThread = new Thread(() ->{
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            getStudent(1, service);
            System.out.println("read completed!");
        });

        writeThread.start();
        readThread.start();

        try {
            writeThread.join();
            readThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearTables(StudentService service){
        service.clearTables();
    }

    public static void addData(StudentService service){
        StuData stuData = new StuData(1, "Arun", 1);
        DeptData deptData = new DeptData(1, "cse");

        try {
            service.addData(stuData, deptData);
        }
        catch (DataAccessException e){
            System.out.println("Database exception caught!");
            e.printStackTrace();
            System.out.println("Rolled back.....");
        }
    }

    public static void getStudent(int id, StudentService service){
        Student student = service.getSudent(id);
        System.out.println(student);
    }
}
