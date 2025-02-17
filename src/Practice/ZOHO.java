package Practice;

import java.util.Scanner;

public class ZOHO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        System.out.println(getColumnValue(num));
    }

    private static String getColumnValue(int num) {
        if(num <= 1){
            return "";
        }

        int quotient = num / 26;
        int remainder = num % 26;
        String value = "";

        if(remainder == 0){
            value = "Z";
            quotient -= 1;
        }
        else{
            value = String.valueOf((char)('A' + remainder - 1));
        }

        System.out.println(quotient +" : " + remainder + " : " + num);

        return getColumnValue(quotient) + value;
    }
}
