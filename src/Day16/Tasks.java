package Day16;

import Day15.Student;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Tasks {
    public static void main(String[] args) {

        //Task-1 -> Filter the even numbers from the list using Predicate
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        IntPredicate evenPredicate = a -> a % 2 == 0;
        filter(list, evenPredicate);
        System.out.println("________________________");


        //Task-2 -> filter the strings starts with the given letter
        List<String> stringList = Arrays.asList("Arun", "Aravinth", "Karthi");
        Predicate<String> matcher = s -> s.charAt(0) == 'A';
        System.out.println("The strings starts with A : ");
        filterString(stringList, matcher).forEach(System.out::println);
        System.out.println("________________________");


        //Task-3 -> filter students with passing grades
        List<Student> students = Arrays.asList(
                new Student(01, "Arun", "CSE", 80),
                new Student(02, "Aravinth", "EEE", 85),
                new Student(03, "Karthi", "EEE", 75)
        );
        Predicate<Student> checker = student -> student.getScore() >= 80;
        System.out.println("The students who got pass marks : ");
        filterStudents(students, checker).forEach(student -> System.out.println(student.getName()));
        System.out.println("________________________");


        //Task-4 -> modify the students grades by adding 10 for each student
        Consumer<Student> adder = student -> student.addScore(10);
        modifyGrades(students, adder);
        System.out.println("Scores after modified");
        students.forEach(student -> System.out.println(student.getScore()));
        System.out.println("________________________");


        //Task-5 -> find the sum of two numbers using BiConsumer
        int a = 5, b = 10;
        BiConsumer<Integer, Integer> add = (u, v) -> System.out.println("Sum of " + u + " and " + v + " is " + (u + v));
        add.accept(a, b);
        System.out.println("________________________");


        //Task-6 -> return lengths for their corresponding Strings
        Function<String, Integer> length = String::length;
        System.out.println("Length of the strings : ");
        for (String str : stringList){
            System.out.println("Length of " + str + " is " + length.apply(str));
        }

    }

    public static void filter(List<Integer> list, IntPredicate func){
        System.out.print("Filtered values : ");
        for(int num : list){
            if(func.test(num)){
                System.out.print(num + " ");
            }
        }

        System.out.println();
    }

    public static List<String> filterString(List<String> list, Predicate<String> func){
        List<String> filteredList = new ArrayList<>();
        for(String str : list){
            if(func.test(str)){
                filteredList.add(str);
            }
        }

        return filteredList;
    }


    public static List<Student> filterStudents(List<Student> students, Predicate<Student> func){
        List<Student> filteredList = new ArrayList<>();
        for(Student stu : students){
            if(func.test(stu)){
                filteredList.add(stu);
            }
        }

        return filteredList;
    }


    public static void modifyGrades(List<Student> students, Consumer<Student> func){
        for(Student stu : students){
            func.accept(stu);
        }
    }

    public static void mapLengths(List<String> list, Function<String, Integer> func){
        for(String str : list){
            func.apply(str);
        }
    }
}
