package Day3.InterfacePart1;

public class withFields {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.area(4));
    }
}


interface Constants{
    //public, static and final
    float PI = 3.14f;
}

class Circle implements Constants{

    public int area(int radius){
        return (int)(PI * (radius * 2));
    }
}





