package Day3.AbstractClass;

public class Implementation {
    public static void main(String[] args) {
        Shape shape = new Circle(4);
        System.out.println(shape.calculateArea());

        shape = new Rectangle(2, 4);
        System.out.println(shape.calculateArea());
    }
}

abstract class Shape{
    String shape;

    Shape(String shape){
        this.shape = shape;
    }

    public String getShape(){
        return shape;
    }

    abstract public int calculateArea();
}

class Rectangle extends Shape {
    protected int length;
    protected int breadth;

    Rectangle(int length, int breadth){
        super("Rectangle");
        this.length = length;
        this.breadth = breadth;
    }

    Rectangle(int value, String shape){
        super(shape);
        this.length = value;
        this.breadth = value;
    }

    public int calculateArea(){
        return length * breadth;
    }
}

class Circle extends Shape {
    private int radius;

    Circle(int radius){
        super("Circle");
        this.radius = radius;
    }

    public int calculateArea(){
        return (int)(3.14f * (radius * 2));
    }
}
