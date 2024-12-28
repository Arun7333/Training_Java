package Day2.thisKeywordAndOverloading;

public class MethodOverloading {
    public static void main(String[] args) {
        System.out.println(area(2));
        System.out.println(area(2, 4));
        System.out.println(area(2.0f, 5.0f));

    }

    public static int area(int radius){
        return (22 / 7) * (radius *radius);
    }

    public static int area(int length, int breadth){
        return length * breadth;
    }

    public static float area(float base, float height){
        return (1 / 2) * (base * height);
    }
}

