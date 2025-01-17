package Junit;

public class StringReverse {
    public String reverse(String str){
        String temp = str.replaceAll(" ", "");
        if(temp.isEmpty() || str.length() == 1) return str;

        return new StringBuilder(str).reverse().toString();
    }
}
