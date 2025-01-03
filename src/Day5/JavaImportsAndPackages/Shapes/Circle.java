package Day5.JavaImportsAndPackages.Shapes;

public class Circle {
    private int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    public float area(){
        return (float)Math.PI * (radius * radius);
    }
}

