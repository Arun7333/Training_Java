package Day3.InterfacePart2;

public class MultipleInterfaces {

}

interface Printer{
    public void print();
}

interface Scanner{
    public void scan();
}

class AllInOne implements Printer, Scanner{
    public void print(){
        System.out.println("Printing");
    }

    public void scan(){
        System.out.println("Scanning");
    }
}
