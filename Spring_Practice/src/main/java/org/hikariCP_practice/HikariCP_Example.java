package org.hikariCP_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.transaction_practise.Transaction_Demo;
import org.transaction_practise.services.StudentService;

import javax.sql.DataSource;

public class HikariCP_Example {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HikariConfigg.class);
        StudentService service = context.getBean(StudentService.class);

//        Transaction_Demo.clearTables(service);
//        Transaction_Demo.addData(service);
//        Transaction_Demo.getStudent(1, service);
        Transaction_Demo.runByThreads(service);
    }
}
