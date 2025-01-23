package Day18;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solutions {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Arun", "CS", new int[]{85, 89, 95, 99, 79}));
        students.add(new Student("Aravinth", "Maths", new int[]{95, 79, 75, 79, 69}));
        students.add(new Student("Karthi", "Physics", new int[]{55, 59, 55, 79, 49}));
        students.add(new Student("John", "CS", new int[]{25, 29, 35, 29, 29}));


        //Task-1 -> Find the top 3 students based on their average marks.
        List<Student> top3Students = students.stream().sorted((u, v) -> v.getAverageMark() - u.getAverageMark()).limit(3).toList();
        System.out.println("Top 3 students :");
        top3Students.stream().map(Student::getName).forEach(System.out::println);
        System.out.println("____________________________");


        //Task-2 -> Assign a grade (A, B, C, D) to each student based on their average marks.
        Function<Integer, Character> grader = (a) -> a >= 90 ? 'A' : a >= 80 ? 'B' : a >=50 ? 'D' : 'U';
        students.stream().forEach(student -> {
            student.setGrade(grader.apply(student.getAverageMark()));
        });

        System.out.println("Students marks and their corresponding grades : ");
        students.forEach(student -> {
            System.out.println(student.getAverageMark() + " : " + student.getGrade());
        });
        System.out.println("____________________________");


        //Task-3 -> Find the average marks for each department.
        Map<String, Double> departmentAverage = students.stream().collect(
                Collectors.groupingBy(
                        Student::getDepartment,
                        Collectors.averagingInt(Student::getAverageMark)
                )
        );
        System.out.println("Department and their average marks : ");
        departmentAverage.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
        System.out.println("____________________________");


        //Task-4 -> Identify the top student in each department.
        Map<String, Optional<Student>> topStudents = students.stream().collect(
                Collectors.groupingBy(
                        Student::getDepartment,
                        Collectors.maxBy(Comparator.comparingInt(Student::getAverageMark))
                )
        );
        System.out.println("Top students in each department :");
        topStudents.entrySet().stream().forEach(entry -> {
            System.out.println(
                    entry.getKey() + " : " + entry.getValue().get().getName()
            );
        });
        System.out.println("____________________________");


        //Task-5 -> Count how many students failed in each department (average marks < 50).
        long count = students.stream().filter(student -> student.getAverageMark() < 50).count();
        System.out.println("Count of the students failed : " + count);
        System.out.println("____________________________");
    }
}
