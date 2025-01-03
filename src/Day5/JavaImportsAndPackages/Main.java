package Day5.JavaImportsAndPackages;

/*
    Create a package shapes with two classes:
        Circle with a method to calculate the area of a circle.
        Rectangle with a method to calculate the area of a rectangle.
    Write a Main class in the default package to import and use these classes.
*/

import Day5.JavaImportsAndPackages.Shapes.*;


public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.area());

        Rectangle rectangle = new Rectangle(2, 3);
        System.out.println(rectangle.area());
    }
}
