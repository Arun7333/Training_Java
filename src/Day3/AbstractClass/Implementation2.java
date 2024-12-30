package Day3.AbstractClass;

public class Implementation2 {
    public static void main(String[] args) {
        Appliance appliance = new Fan();
        appliance.turnOn();
        appliance.turnOff();
    }
}

abstract class Appliance{
    private String name;

    Appliance(String name){
        this.name = name;
    }

    abstract public void turnOn();

    abstract public void turnOff();
}

class Fan extends Appliance{
    Fan(){
        super("Fan");
    }

    public void turnOn(){
        System.out.println("Fan turned on!");
    }

    public void turnOff(){
        System.out.println("Fan turned off!");
    }
}
