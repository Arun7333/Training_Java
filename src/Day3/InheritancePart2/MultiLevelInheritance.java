package Day3.InheritancePart2;

public class MultiLevelInheritance {
    public static void main(String[] args) {
        Rectangle shape = new Square(4);
        System.out.println(shape.getShape() + "'s Area is: " + shape.area());
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

    abstract public int area();
}

class Rectangle extends Shape{
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

    public int area(){
        return length * breadth;
    }
}

class Square extends Rectangle{
    Square(int value){
        super(value, "Square");
    }

    public int area(){
        return super.area();
    }
}
