package Day6.LangObject;

import Day2.Library.LibraryManagement;

public class TestObjectMethods {
    public static void main(String[] args) {
        LibraryManagement obj = new LibraryManagement();

        //Few methods in lang.Object class
        System.out.println(obj.getClass());
        System.out.println(obj.toString());
        System.out.println(obj.hashCode());
    }
}
