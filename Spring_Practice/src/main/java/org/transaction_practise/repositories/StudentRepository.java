package org.transaction_practise.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.transaction_practise.Datas.DeptData;
import org.transaction_practise.Datas.StuData;
import org.transaction_practise.Entities.Student;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addStudent(StuData data){
        String stuQuery = "INSERT INTO students VALUES (?, ?, ?);";

        jdbcTemplate.update(stuQuery, data.getStuId(), data.getStuName(), data.getDeptId());

        System.out.println("student inserted!");
    }

    public void addDepartment(DeptData data){
        String deptQuery = "Insert into departments values(?, ?);";

        jdbcTemplate.update(deptQuery, data.getDeptId(), data.getDeptName());

        System.out.println("department inserted!");
    }

    public void clearTables(){
        String clearQuery = "truncate table ";

        jdbcTemplate.update(clearQuery + "students");
        jdbcTemplate.update(clearQuery + "departments");

        System.out.println("Tables cleared!");
    }

    public Student readStudent(int id){
        String query = "select * from students where id = ?";

        return jdbcTemplate.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));
    }
}
