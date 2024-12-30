package Day3.Polymorphism;

public class CompileTime {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.add(1.2, 2.3));
        System.out.println(calculator.add(1, 2, 3));
    }
}

class Calculator{

    public int add(int a, int b){
        return a + b;
    }

    public double add(double a, double b){
        return a + b;
    }

    public int add(int a, int b, int c){
        return a + b + c;
    }
}
