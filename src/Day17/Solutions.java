package Day17;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Solutions {
    public static void main(String[] args) {

        //Task-1 -> Supplier that returns the current date and time
        Supplier<LocalDateTime> currDateAndTime = LocalDateTime::now;
        System.out.println("Current date and Time is : " + currDateAndTime.get());
        System.out.println("________________________");


        //task-2 -> Supplier that generates a random number between 1 and 100 and prints it 5 times
        Random random = new Random();
        System.out.println("Random numbers");
        Supplier<Integer> generateRandom = () -> random.nextInt(100);
        for(int i = 0; i < 5; i++) {
            System.out.println(generateRandom.get());
        }
        System.out.println("________________________");


        //Task-3 -> UnaryOperator that converts a given string to uppercase
        UnaryOperator<String> toUpper = String::toUpperCase;
        System.out.println("arun to uppercase is " + toUpper.apply("arun"));
        System.out.println("________________________");


        //Task-4 -> BinaryOperator to find the maximum of two integers
        IntBinaryOperator max = Math::max;
        System.out.println("Maximum of 10 and 20 is : " + max.applyAsInt(10, 20));
        System.out.println("________________________");


        //Task-5 -> Accepts a String input, converts it to uppercase if it's not null, and prints "Empty input" if the string is null
        Optional<String> str = Optional.of("arun");
        toupperCase(str);
        str = Optional.empty();
        toupperCase(str);
        System.out.println("________________________");


        //Task-6 -> Optional to provide a default value of "Guest" when no name is provided
        Optional<String> name = Optional.ofNullable(null);
        System.out.println(name.orElse("Default name"));
        System.out.println("________________________");


        //Task-7 -> Method reference to a static method Math::sqrt to calculate the square root of a list of numbers
        List<Integer> numbers = Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64);
        System.out.println("Square roots : ");
        numbers.stream().map(Math::sqrt).forEach(System.out::println);
        System.out.println("________________________");


        //Task-8 -> Method reference is used to compare strings (e.g., String::compareToIgnoreCase) in a list and sort them
        List<String> strings = Arrays.asList("ArUn", "ArAvinth", "KarThi");
        Collections.sort(strings, String::compareToIgnoreCase);
        System.out.println("List after sorted :");
        strings.forEach(System.out::println);
        System.out.println("________________________");


        //Task-9 -> A functional interface StudentFactory that contains a method create(String name, int marks).
        // Use a constructor reference to implement this method to create Student objects.
        StudentsFactory factory = Student::new;
        System.out.println("Factory created!");
        Student student1 = factory.create("Arun", 100);
        System.out.println("________________________");


        //Task-10 -> an instance method displayStudentDetails in the Student class to print the student's details.
        // Use a method reference to call this method for each student in a list.
        List<Student> students = Arrays.asList(factory.create("Arun", 100), factory.create("Aravinth", 95));
        students.forEach(Student::displayDetails);
    }

    public static void toupperCase(Optional<String> str){
        System.out.println(str.orElse("empty input").toUpperCase());
    }

}
