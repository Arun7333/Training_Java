package org.dao_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        DAO_Example dao = (DAO_Example) context.getBean(DAO_Example.class);

        dao.clearTable();

        List<Object[]> params = new ArrayList<>();
        params.add(new Object[]{1, "Arun", "arun@gmail.com", 100});
        params.add(new Object[]{2, "Aravinth", "aravinth@gmail.com", 99});
        params.add(new Object[]{3, "Pavithra", "pavi@gmail.com", 89});

        dao.addBatch(params);

        List<User> users = dao.getUsers();
        System.out.println(users);

        User user = dao.getById(users.get(0).email);
        System.out.println(user);

//        dao.addUser(10, "New", "new1@gmail.com", 200);
        dao.deleteById(users.get(0).id);
    }
}
