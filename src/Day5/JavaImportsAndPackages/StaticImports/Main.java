package Day5.JavaImportsAndPackages.StaticImports;

/*
    Use Math class methods like sqrt() and pow() in a program to calculate the hypotenuse
    of a right-angled triangle using static imports.
*/

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculateHypotenuse(5, 8));
    }

    public static double calculateHypotenuse(int base, int perpendicular){
        return sqrt(pow(base, 2) + pow(perpendicular, 2));
    }
}
