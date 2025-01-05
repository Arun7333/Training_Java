package Day7.ExtraProblems;

import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.println(mayPalindrome(s));
    }

    public static boolean mayPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return helper(s, left, right - 1) || helper(s, left + 1, right);
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean helper(String s, int left, int right){

        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
