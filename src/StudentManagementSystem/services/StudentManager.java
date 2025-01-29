package StudentManagementSystem.services;

import StudentManagementSystem.exceptions.IdAlreadyAvailableException;
import StudentManagementSystem.exceptions.StudentNotAvailableException;
import StudentManagementSystem.models.Manager;
import StudentManagementSystem.models.Student;


import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class StudentManager implements Manager<Student> {
    private Map<Integer, Student> students;

    public StudentManager(){
        students = new ConcurrentHashMap<>();
    }

    public Student newStudent(String name, int age, String email, char grade){
        int id = generateId();
        Student newStudent = new Student(id, name, age, email, grade);
        System.out.println(newStudent.getName() + ", You're Id is " + id);

        return newStudent;
    }

    @Override
    public void add(Student student) {
        if(students.containsKey(student.getId())){
            throw new IdAlreadyAvailableException();
        }
        students.put(student.getId(), student);
    }

    @Override
    public void remove(int id) {
        if(!students.containsKey(id)){
            throw new StudentNotAvailableException();
        }

        students.remove(id);
    }

    @Override
    public Optional<Student> get(int id) {
        return Optional.ofNullable(students.get(id));
    }

    public void updateName(int id, String name){
        Optional<Student> student = get(id);
        if(student.isEmpty()){
            throw new StudentNotAvailableException();
        }

        student.get().setName(name);
    }

    public void updateEmail(int id, String email){
        Optional<Student> student = get(id);
        if(student.isEmpty()){
            throw new StudentNotAvailableException();
        }

        student.get().setEmail(email);
    }

    public void updateGrade(int id, char grade){
        Optional<Student> student = get(id);
        if(student.isEmpty()){
            throw new StudentNotAvailableException();
        }

        student.get().setGrade(grade);
    }

    public void updateAge(int id, int age){
        Optional<Student> student = get(id);
        if(student.isEmpty()){
            throw new StudentNotAvailableException();
        }

        student.get().setAge(age);
    }

    public void showAll(){
        System.out.println("List of Students :");
        for (Integer id : students.keySet()){
            Student student = students.get(id);
            System.out.print("Id : " + student.getId() + ", ");
            System.out.print("Name : " + student.getName() + ", ");
            System.out.print("Age : " + student.getAge() + ", ");
            System.out.print("Email : " + student.getEmail() + ", ");
            System.out.println("Grade : " + student.getGrade() + ".");
        }
    }

    public int generateId(){
        int randomID = 1;
        while(students.containsKey(randomID)){
            randomID = idGenerator.nextInt(1000);
        }

        return randomID;
    }

}
