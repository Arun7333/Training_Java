package Practice;

public class UpcastingPractice {
    public static void main(String[] args) {
        SuperClass obj = (Middle) new Derived();
        obj.print();
        obj.fun();
        obj.run();
    }
}

class SuperClass {
    public void print(){
        System.out.println("super");
    }

    public void Super(){
        System.out.println("sup");
    }

    public void fun(){
        System.out.println("sup");
    }

    public void run(){
        System.out.println("sup");
    }
}

class Middle extends SuperClass{
    @Override
    public void print() {
        System.out.println("middle");
    }

    @Override
    public void fun() {
        System.out.println("mid");
    }

    public void middle(){
        System.out.println("mid");
    }
}

class Derived extends Middle{
    @Override
    public void print() {
        System.out.println("derived");
    }

    public void derived(){
        System.out.println("der");
    }

    @Override
    public void fun(){
        System.out.println("derived");
    }
}
