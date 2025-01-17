package Junit;

public class Palindrome {
    public boolean check(String str){
        if(str.length() <= 1) return true;

        str = str.trim().replaceAll(" ", "");
        int left = 0;
        int right = str.length() - 1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
