package Day5.Enum.BasicEnum;

/*
        Define an enum Day with values for all days of the week.
        Write a program to print a message like "It's a weekday" or "It's a weekend" based on the day.
*/

import Day5.Enum.EnumWithMethods.Season;

public class Main{
    public static void main(String[] args) {
        for(Day today : Day.values()){
            guessTheDay(today);
        }
    }

    public static void guessTheDay(Day day){
        if(day == Day.SATURDAY || day == Day.SUNDAY){
            System.out.println(day + " is weekend");
        }
        else System.out.println(day + " is weekday");
    }
}
