package StudentManagementSystem.models;

import StudentManagementSystem.exceptions.InvalidAgeException;
import StudentManagementSystem.exceptions.InvalidEmailException;
import StudentManagementSystem.exceptions.InvalidNameException;
import StudentManagementSystem.utility.Patterns;

import java.io.Serializable;
import java.util.regex.Matcher;

public class Person implements Serializable {
    protected String name;
    protected int age;
    protected String email;

    public Person(String name, int age, String email){
        setName(name);
        setAge(age);
        setEmail(email);
    }

    public void setName(String name){
        //null check
        if(name == null){
            throw new InvalidNameException("Name should not be null value!");
        }

        //Name should not be empty
        name = name.trim();
        if(name.isEmpty()){
            throw new InvalidNameException("Name should not be empty!");
        }

        //Regex for Name: only allows alphabets and spaces between words
        Matcher nameMatcher = Patterns.namePattern.matcher(name);
        if(!nameMatcher.matches()){
            throw new InvalidNameException("Name should not have special characters and numbers!");
        }

        this.name = name;
    }

    public void setAge(int age){
        //Checking the age limit
        if(age < 5){
            throw new InvalidAgeException("Age should not be less then 5!");
        }
        else if(age > 120){
            throw new InvalidAgeException("Are you from another planet: How " + age + " age is possible...\n" +
                    "Please give a correct Age!"
            );
        }

        this.age = age;
    }

    public void setEmail(String email){
        //null check
        if(name == null){
            throw new InvalidEmailException("Email should not be null value!");
        }

        //Email should not be empty
        email = email.trim();
        if(email.isEmpty()){
            throw new InvalidEmailException("Email should not be empty!");
        }

        //Checking Email validity
        Matcher emailMatcher = Patterns.emailPattern.matcher(email);
        if(!emailMatcher.matches()){
            throw new InvalidEmailException("Email is invalid!");
        }

        this.email = email;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Age: " + age
                + ", Email: " + email;
    }
}
