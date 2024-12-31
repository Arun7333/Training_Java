package Day3.InterfacePart2;

public class InterfaceInheritance { }

interface Vehicle{
    public void start();
}

interface FourWheeler extends Vehicle{
    int wheelCount = 4;
}

interface TwoWheeler extends Vehicle{
    int wheelCount = 5;
}

