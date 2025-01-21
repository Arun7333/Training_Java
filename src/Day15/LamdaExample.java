package Day15;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LamdaExample {

    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        students.add(new Student(1, "Arun", "CSE", 90));
        students.add(new Student(2, "Aravind", "EEE", 95));
        students.add(new Student(3, "Karthi", "CSE", 80));
        students.add(new Student(4, "Kathiravan", "EEE", 85));

        //Task-1 ->  sort the list of students by their score(CGPA)
        Collections.sort(students, (u, v) -> v.getScore() - u.getScore());

        //Task-2 -> top scorers of each department
        Map<String, Optional<Student>> topScorers = getTopScorers();
        System.out.println("Top scorers of each department :");
        topScorers.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue().get().getName()));

        //Task-3 -> transform the names into list
        List<String> names = transfromNames();
        System.out.println("List of the students name : ");
        names.stream().forEach(System.out::println);

        //Task-4 -> average Score of the list of students
        int averageScore = averageScore();
        System.out.println("Average score of the students is : " + averageScore);

        //Task-5 -> collecting the students by their first letter
        List<Student> studentList = groupByFirstLetter('A');
        System.out.println("The students name starts with A : ");
        studentList.stream().map(Student::getName).forEach(System.out::println);

    }

    public static Map<String, Optional<Student>> getTopScorers(){

        return students.stream().collect(
                Collectors.groupingBy(
                        Student::getDept,
                        Collectors.maxBy(Comparator.comparing(Student::getScore))
                )
        );
    }

    public static List<String> transfromNames(){

        return students.stream()
                .map(student -> "Student : " + student.getName().toUpperCase())
                .collect(Collectors.toList());
    }

    public static int averageScore(){

        return students.stream().map(Student::getScore).reduce((a, b) -> a + b).orElse(0) / students.size();
    }

    public static List<Student> groupByFirstLetter(char firstLetter){

        return students.stream()
                .filter(
                        student -> !student.getName().isEmpty() &&
                                student.getName().charAt(0) == firstLetter
                )
                .collect(Collectors.toList());
    }
}
