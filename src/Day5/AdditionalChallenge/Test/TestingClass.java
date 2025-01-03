package Day5.AdditionalChallenge.Test;

/*
    Create a mini-application combining these topics:
    Use a package utilities containing a generic class Container<T> to store any object.
    Use an enum Priority with values LOW, MEDIUM, and HIGH.
    Use a Main class to demonstrate autoboxing, access modifiers, and package imports.
*/

//Package Imports
import Day5.AdditionalChallenge.Utilities.*;

public class TestingClass {
    public static void main(String[] args) {

        //Autoboxing
        Integer intNum = Integer.valueOf(5);
        System.out.println(intNum);

        //Access Modifiers
        //Container is accessible in other packages because it is public
        Container<Priority> conatiner = new Container(Priority.HIGH);
        System.out.println(conatiner.getObject());
    }
}
