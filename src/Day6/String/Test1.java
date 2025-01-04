package Day6.String;

/*
    Write a program that takes a sentence as input from the user and performs the following operations:
    Count the number of words in the sentence.
    Reverse the entire sentence.
    Replace all vowels in the sentence with the character '*'.
*/


import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println("Words count: " + countWords(str));
        System.out.println("Reversed String: " + reverseString(str));
        System.out.println("Vowels replaced String: " + removeVowels(str));
    }

    public static int countWords(String str){
        String strWithoutSpace = str.trim().replaceAll(" ", "");

        return strWithoutSpace.length();
    }

    public static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static String removeVowels(String str){
        return str.replaceAll("[aeiouAEIOU]", "*");
    }
}
